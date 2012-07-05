package br.com.fourlinux.tarefasassincronas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;


public class TelaPrincipal extends Activity {
    /** Called when the activity is first created. */
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /** Chamando o Processo AsyncTask
         *  Os parametros passado no método execute, vão para o método
         *  doInBackground(Integer... params).
         */
        Processo processo = new Processo(this);
        processo.execute(3000, 2000, 4000);
    }

    public class Processo extends AsyncTask<Integer, String, Integer> {

        private ProgressDialog progress;
        private Context context;

        public Processo(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            //Cria novo um ProgressDialogo e exibe
            progress = new ProgressDialog(context);
            progress.setMessage("Aguarde...");
            progress.show();
        }

        @Override
        protected Integer doInBackground(Integer... paramss) {
            for (int i = 0; i < paramss.length; i++) {
                try {
                    //Simula processo...
                    Thread.sleep(paramss[i]);
                    //Atualiza a interface através do onProgressUpdate
                    publishProgress(i + "...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return 1;
        }

        @Override
        protected void onPostExecute(Integer result) {
            //Cancela progressDialogo
            progress.dismiss();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //Atualiza mensagem
            progress.setMessage(values[0]);
        }
    }
}