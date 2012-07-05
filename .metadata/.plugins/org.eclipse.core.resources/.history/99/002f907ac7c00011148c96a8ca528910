package br.com.android;

import java.io.IOException;

import android.app.Activity;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class RecordVideoActivity extends Activity {

	//objeto do tipo Camera 
	private Camera myCamera;
	//instanciando nossa classe MyCameraSurfaceView
	private MyCameraSurfaceView myCameraSurfaceView;
	//objeto MediaRecorder
	private MediaRecorder mediaRecorder;
	Button myButton;
	//objeto SurfaceHolder
	SurfaceHolder surfaceHolder;
	boolean recording;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		recording = false;

		setContentView(R.layout.main);

		// chama a camera para um preview
		myCamera = getCameraInstance();
		
		if (myCamera == null) {
			Toast.makeText(RecordVideoActivity.this, "Falha em acionar a Câmera",Toast.LENGTH_LONG).show();
		}
		
		
		
		
		//aqui é chamado nosso método de controle da camera
		myCameraSurfaceView = new MyCameraSurfaceView(this, myCamera);
		FrameLayout myCameraPreview = (FrameLayout) findViewById(R.id.videoview);
		myCameraPreview.addView(myCameraSurfaceView);

		//botão de gravação
		myButton = (Button) findViewById(R.id.mybutton);
		myButton.setOnClickListener(myButtonOnClickListener);
	}

	Button.OnClickListener myButtonOnClickListener = new Button.OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			if (recording) {
				// para a gravação e libera a camera
				mediaRecorder.stop(); // para a gravação
				releaseMediaRecorder(); // chama o método

				// sai depois de salvar
				finish();
			} else {

				// Libera a Camera depois do MediaRecorder começar
				releaseCamera();

				if (!prepareMediaRecorder()) {
					Toast.makeText(RecordVideoActivity.this,"Falha no prepareMediaRecorder()!\n - Finalizando -",Toast.LENGTH_LONG).show();
					finish();
				}

				
				
				mediaRecorder.start();
				recording = true;
				myButton.setText("Parar Gravação");
			}
		}
	};

	private Camera getCameraInstance() {
		// TODO Auto-generated method stub
		Camera c = null;
		try {
			c = Camera.open(); // tentando obter uma instância de Câmara
		} catch (Exception e) {
			// A câmera não está disponível (em uso ou não existe)
		}
		return c; //retorna null se a câmera não está disponível
	}

	//método que grava com a camera
	private boolean prepareMediaRecorder() {
		myCamera = getCameraInstance();
		mediaRecorder = new MediaRecorder();

		myCamera.unlock();
		mediaRecorder.setCamera(myCamera);

		mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
		mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);

		mediaRecorder.setProfile(CamcorderProfile.get(CamcorderProfile.QUALITY_HIGH));

		mediaRecorder.setOutputFile("/sdcard/gravação.mp4");//Seta onde o arquivo de saida vai ser salvo
		mediaRecorder.setMaxDuration(60000); // Seta para os filmes durarem no maximo 60 segundos.
		mediaRecorder.setMaxFileSize(5000000); // Seta para o arquivo não passe de 5 mb
		
		

		mediaRecorder.setPreviewDisplay(myCameraSurfaceView.getHolder().getSurface());

		try {
			mediaRecorder.prepare();
		} catch (IllegalStateException e) {
			releaseMediaRecorder();
			return false;
		} catch (IOException e) {
			releaseMediaRecorder();
			return false;
		}
		return true;

	}

	@Override
	protected void onPause() {
		super.onPause();
		releaseMediaRecorder(); // se você estiver usando MediaRecorder, liberá-lo primeiro
								
		releaseCamera(); // liberar a câmera imediatamente em caso de pausa
	}

	
	
	//método que libera a câmera apos a gravação 
	private void releaseMediaRecorder() {
		if (mediaRecorder != null) {
			mediaRecorder.reset(); // limpa as configurações de gravação
			mediaRecorder.release(); // libera o objeto
			mediaRecorder = null;
			myCamera.lock(); // trava a camera para ser usada novamente
		}
	}
	//método para liberar totalmente a camera
	private void releaseCamera() {
		if (myCamera != null) {
			myCamera.release(); // libera a camera para outras aplicações
			myCamera = null;
		}
	}

	
}

