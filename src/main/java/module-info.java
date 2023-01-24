module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires gson;

    opens com.weymar87 to javafx.fxml;
    exports com.weymar87;
    exports com.weymar87.utils;
    opens com.weymar87.utils to javafx.fxml;
}
