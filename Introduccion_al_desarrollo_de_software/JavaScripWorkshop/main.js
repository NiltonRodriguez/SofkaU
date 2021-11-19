// Anonymous function for the game elements.
(function(){
    self.Board = function(width, height){
        this.width = width;
        this.height = height;
        this.playing = false;
        this.game_over = false;
        this.bars = [];
        this.ball = null;
    }
    // Board prototype.
    self.Board.prototype = {
        get elements(){
            var elements = this.bars;
            elements.push(ball);
            return elements;
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
        this.context = canvas.context("2d");
    }
})();

window.addEventListener("load", main);

function main(){
    var board = new Board(800, 400);
    var canvas = document.getElementById("canvas");
    var board_view = new BoardView(canvas, board);
}
