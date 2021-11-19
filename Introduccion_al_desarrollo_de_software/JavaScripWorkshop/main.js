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
        this.speedY = 0;
        this.board = board;
        this.direction = 1;

        board.ball = this;
        this.kind = "circle";
    }

    self.Ball.prototype = {
        move: function(){
            this.x += (this.speedX * this.direction);
            this.y += this.speedY;
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
        clean: function(){
            this.context.clearRect(0, 0, this.board.width, this.board.height);
        },
        draw: function(){
            for(var i = this.board.elements.length -1; i >= 0; i--){
                var el = this.board.elements[i];

                draw(this.context, el);
            }
        },
        play: function(){
            if (this.board.playing){
                board_view.clean();
                board_view.draw();
                this.board.ball.move();
            }
        }
    }

    //Helper method.
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

board_view.draw();
window.requestAnimationFrame(controller);

function controller(){
    board_view.play();
    window.requestAnimationFrame(controller);
}
