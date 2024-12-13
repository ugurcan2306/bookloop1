package com.example;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class feedpageController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorpane2feedpage;

    @FXML
    private AnchorPane anchorpaneOfFeedPage;

    @FXML
    private AnchorPane anchorpanefeedpage3;

    @FXML
    private AnchorPane anchorpaneforcomment2;

    @FXML
    private ImageView dislikeimage;

    @FXML
    private Pane feedpagepane;

    @FXML
    private ImageView imageforprofile2;

    @FXML
    private ImageView imageviewdislike;

    @FXML
    private ImageView imageviewfeedpageprofile;

    @FXML
    private ImageView imageviewforbook1;

    @FXML
    private ImageView imageviewforbook2;

    @FXML
    private ImageView imageviewfordislike;

    @FXML
    private Label labeldislikeforcomment2;

    @FXML
    private Label labeldislikesayisi;

    @FXML
    private Label labellikeforcomment2;

    @FXML
    private Label labellikesayisi;

    @FXML
    private ImageView likeimage;

    @FXML
    private Pane panefeedpage2;

    @FXML
    private Pane panefeedpagecomment;

    @FXML
    private Pane paneforcomment;

    @FXML
    private Pane paneforcomment2;

    @FXML
    private Pane paneoffeedpage;

    @FXML
    private Text textForYou;

    @FXML
    private Text textIamworm;

    @FXML
    private TextFlow textflowforcomment;

    @FXML
    private Text textforauthor1;

    @FXML
    private Text textforauthor2;

    @FXML
    private TextFlow textforcomment2;

    @FXML
    private Text textforuser2;

    @FXML
    private Text textyorum1;

    private int likeCount = 0;  // Variable to track total like count
    private int dislikeCount = 0;
    private int likeCount2 = 0;  // Variable to track total like count
    private int dislikeCount2 = 0;

    @FXML
    void initialize() {
        assert anchorpane2feedpage != null : "fx:id=\"anchorpane2feedpage\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert anchorpaneOfFeedPage != null : "fx:id=\"anchorpaneOfFeedPage\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert anchorpanefeedpage3 != null : "fx:id=\"anchorpanefeedpage3\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert anchorpaneforcomment2 != null : "fx:id=\"anchorpaneforcomment2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert dislikeimage != null : "fx:id=\"dislikeimage\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert feedpagepane != null : "fx:id=\"feedpagepane\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert imageforprofile2 != null : "fx:id=\"imageforprofile2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert imageviewdislike != null : "fx:id=\"imageviewdislike\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert imageviewfeedpageprofile != null : "fx:id=\"imageviewfeedpageprofile\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert imageviewforbook1 != null : "fx:id=\"imageviewforbook1\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert imageviewforbook2 != null : "fx:id=\"imageviewforbook2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert imageviewfordislike != null : "fx:id=\"imageviewfordislike\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert labeldislikeforcomment2 != null : "fx:id=\"labeldislikeforcomment2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert labeldislikesayisi != null : "fx:id=\"labeldislikesayisi\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert labellikeforcomment2 != null : "fx:id=\"labellikeforcomment2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert labellikesayisi != null : "fx:id=\"labellikesayisi\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert likeimage != null : "fx:id=\"likeimage\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert panefeedpage2 != null : "fx:id=\"panefeedpage2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert panefeedpagecomment != null : "fx:id=\"panefeedpagecomment\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert paneforcomment != null : "fx:id=\"paneforcomment\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert paneforcomment2 != null : "fx:id=\"paneforcomment2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert paneoffeedpage != null : "fx:id=\"paneoffeedpage\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textForYou != null : "fx:id=\"textForYou\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textIamworm != null : "fx:id=\"textIamworm\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textflowforcomment != null : "fx:id=\"textflowforcomment\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textforauthor1 != null : "fx:id=\"textforauthor1\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textforauthor2 != null : "fx:id=\"textforauthor2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textforcomment2 != null : "fx:id=\"textforcomment2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textforuser2 != null : "fx:id=\"textforuser2\" was not injected: check your FXML file 'feedpage.fxml'.";
        assert textyorum1 != null : "fx:id=\"textyorum1\" was not injected: check your FXML file 'feedpage.fxml'.";

        labellikesayisi.setText(String.valueOf(likeCount));
        labeldislikesayisi.setText(String.valueOf(dislikeCount));

        labellikeforcomment2.setText(String.valueOf(likeCount2));
        labeldislikeforcomment2.setText(String.valueOf(dislikeCount2));

    }
    // Variable to track dislike count

    @FXML
    void handleLikeImageClick() {
        likeCount++;
        labellikesayisi.setText(String.valueOf(likeCount));
    }
    @FXML
    void handleLikeImage2Click() {
        likeCount2++;
        labellikeforcomment2.setText(String.valueOf(likeCount2));
    }

    @FXML
    void handleDislikeImageClick() {
        dislikeCount++;
        labeldislikesayisi.setText(String.valueOf(dislikeCount));
    }
    @FXML
    void handleDislikeImage2Click() {
        dislikeCount2++;
        labeldislikeforcomment2.setText(String.valueOf(dislikeCount2));
    }


   

}
