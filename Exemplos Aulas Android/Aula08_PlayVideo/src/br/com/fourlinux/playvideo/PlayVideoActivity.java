package br.com.fourlinux.playvideo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoActivity extends Activity {

	//Variavel estatica para caso quiséssemos puxar o video via SD 
	//public static String PATH_TO_FILE = "/mnt/sdcard/video.mp4";
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		VideoView myVideoView = (VideoView) findViewById(R.id.myvideoview);


		
		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(myVideoView);
		
		//Aqui caso quiséssemos puxar o video via streaming 
		//Uri video = Uri.parse("http://yourfavouriteurl/abc.3gp");
		//para puxar o video do sd
		//myVideoView.setVideoPath(PATH_TO_FILE);
		
		Uri video = Uri.parse("android.resource://br.com.fourlinux.playvideo/" + R.raw.video);
		myVideoView.setMediaController(mediaController);
		myVideoView.setVideoURI(video);
		
		myVideoView.start();


	}
}