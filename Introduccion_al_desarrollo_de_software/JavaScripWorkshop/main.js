// Anonymous function for the game elements.
(function(){
    self.Board = function(width, height){
        this.width = width;
        this.height = height;
        this.playing = false;
        this.game_over = false;
        this.bars = [];
        this.ball = null;
        this.playing = false;
    }
    // Board prototype.
    self.Board.prototype = {
        get elements(){
			var elements = this.bars.map(function (bar) { return bar; });
			elements.push(this.ball);
			return elements;
        }
    }
})();
//Anonymous function for the bar creation.
(function(){
    self.Bar = function(x, y, width, height, board){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.board = board;
        this.board.bars.push(this);
        this.kind = "rectangle";
        this.speed = 10;
    }

    self.Bar.prototype = {
        down: function(){
            this.y += this.speed;
        },
        up: function(){
            this.y -= this.speed;
        },
        toString: function(){
            return "x: " + this.x + " y: " + this.y;
        }
    }
})();
// Anonymous function to initialize the ball.
(function(){
    self.Ball = function(x, y, radius, board){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.speedX = 3;
        this.speedY = Math.random();
        this.board = board;
        this.direction = 1;
        this.bounce_angle = 0;
        this.max_bounce_angle = Math.PI / 12;
        this.speed = 3;
        this.width = this.radius * 2;
        this.height = this.radius * 2;

        board.ball = this;
        this.kind = "circle";
    }

    self.Ball.prototype = {
        move: function(){
            this.x += (this.speedX * this.direction);
            this.y += (this.speedY);

            // Collition with left border. Restart position.
            if (this.x <= 10) {
				this.x = 400;
				this.y = 200;
				this.speedX = -this.speedX;
				this.bounce_angle = -this.bounce_angle;
			}
            // Collition with right border. Restart position.
			if (this.x >= 790) {
				this.x = 400;
				this.y = 200;
				this.speedX = -this.speedX;
				this.bounce_angle = -this.bounce_angle;
			}
            // Collition with top border.
			if (this.y <= 10) {
				this.speedY = -this.speedY;
				this.bounce_angle = -this.bounce_angle;
			}
            // Collition with bottom border
            if (this.y >= 390) {
                this.speedY = -this.speedY;
				this.bounce_angle = -this.bounce_angle;
			}
        },
        // Function to set the collition s
        collision: function(bar){
            var relative_intersect_y = (bar.y + (bar.height / 2)) - this.y;

			var normalized_intersect_y = relative_intersect_y / (bar.height / 2);

			this.bounce_angle = normalized_intersect_y * this.max_bounce_angle;
			this.speed_y = this.speed * -Math.sin(this.bounce_angle);
			this.speed_x = this.speed * Math.cos(this.bounce_angle);
			if (this.x > (this.board.width / 2)) this.direction = -1;
			else this.direction = 1;
        }
    }
})();

// Anonymous function to initialize the board.
(function(){
    self.BoardView = function(canvas, board){
        this.canvas = canvas;
        this.canvas.width = board.width;
        this.canvas.height = board.height;
        this.board = board;
        this.context = canvas.getContext("2d");
    }

    self.BoardView.prototype = {
        // Function clear the paddle animations.
        clean: function(){
            this.context.clearRect(0, 0, this.board.width, this.board.height);
        },
        // Function to render the paddles and the ball.
        draw: function(){
            for(var i = this.board.elements.length -1; i >= 0; i--){
                var el = this.board.elements[i];

                draw(this.context, el);
            }
        },
        // Function to chec the collisions between the ball and the paddles.
        check_collisions: function() {
			for (var i = this.board.bars.length - 1; i >= 0; i--) {
				var bar = this.board.bars[i];
				if (hit(bar, this.board.ball)) {
					this.board.ball.collision(bar);
				}
			}
		},
        //Function to update the game over time.
        play: function(){
            if (this.board.playing){
                board_view.clean();
                board_view.draw();
                board_view.check_collisions();
                this.board.ball.move();
            }
        }
    }

    //Helper methods.

    // Method to check if the ball hits other element.
    function hit(a, b){
        var hit = false;
        // Horizontal Collitions
        if (b.x + b.width >= a.x && b.x < a.x + a.width) {
            //vertical collitions
            if (b.y + b.height >= a.y && b.y < a.y + a.height)
                hit = true;
        }
        // a collides b.
        if (b.x <= a.x && b.x + b.width >= a.x + a.width) {
            if (b.y <= a.y && b.y + b.height >= a.y + a.height)
                hit = true;
        }
        // b collides a.
        if (a.x <= b.x && a.x + a.width >= b.x + b.width) {
            if (a.y <= b.y && a.y + a.height >= b.y + b.height)
                hit = true;
        }
        return hit;
    }
    // Function to render the elements in the canvas.
    function draw(context, element){
        switch(element.kind){
            case "rectangle":
                context.fillRect(element.x, element.y, element.width, element.height);
                break;
            case "circle":
                context.beginPath();
                context.arc(element.x, element.y, element.radius, 0, 7);
                context.fill();
                context.closePath();
                break;
        }
    }
})();

var board = new Board(800, 400);
var left_bar = new Bar(20, 130, 25, 100, board);
var right_bar = new Bar(755, 130, 25, 100, board);
var canvas = document.getElementById("canvas");
var board_view = new BoardView(canvas, board);
var ball = new Ball(400, 200, 8, board);

// Listener to move the paddles and pause the game with keys.
document.addEventListener("keydown", function(ev){
    if(ev.keyCode === 38){
        event.preventDefault();
        if (right_bar.y >= 10){
            right_bar.up();
        }
    }else if(ev.keyCode === 40){
        event.preventDefault();
        if (right_bar.y <= 290){
            right_bar.down();
        }
    }else if(ev.keyCode === 87){
        event.preventDefault();
        if (left_bar.y >= 10){
            left_bar.up();
        }
    }else if(ev.keyCode === 83){
        event.preventDefault();
        if (left_bar.y <= 290){
            left_bar.down();
        }
    }else if(ev.keyCode === 32){
        event.preventDefault();
        board.playing = !board.playing;
    }
});

// Display the board and animations.
board_view.draw();
window.requestAnimationFrame(controller);

// Main function that render and control the game.
function controller(){
    board_view.play();
    window.requestAnimationFrame(controller);
}
