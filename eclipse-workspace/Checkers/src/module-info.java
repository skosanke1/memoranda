module Checkers {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens ui to javafx.graphics, javafx.fxml;
}
