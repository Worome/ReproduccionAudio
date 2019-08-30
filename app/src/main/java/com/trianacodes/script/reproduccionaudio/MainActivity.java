package com.trianacodes.script.reproduccionaudio;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button play;
    SoundPool sp;
    int sonido_de_Reproduccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.btn_SoundPool);

        /* Para usar SoundPool es necesario crear un objeto al que se le dan los siguientes argumentos:
           máximo de reproducciones simultáneas, tipo de stream audio que normalmente es STREAM_MUSIC
           y la calidad de reproducción. Este último parámetro ya no se usa, pero Android sigue pidiéndolo,
           por eso se pone 1. */
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);

        /* Ahora se carga el archivo de audio en el objeto SoundPool dándole los siguientes parámetros:
           contexto, ubicación del archivo y la prioridad, aunque este último ya no tenga ninguna utilidad.
         */
        sonido_de_Reproduccion = sp.load(this,R.raw.uno,1);

    }

    public void audioSoundPool(View view){

        /* Instrucción para reproducir audio en el que se le da los siguientes parámetros:
               * El sonido a reproducir.
               * Volumen del altavoz izquierdo.
               * Volumen del altavoz derecho.
               * La prioridad que la ponemos en 1.
               * El número de repeticiones que puede ser:
                    a) -1: Se repite contínuamente.
                    b) 0: Se reproduce una vez.
                    c) 1: Se escuchará y al cabo de un tiempo pequeño se vuelve a reproducir.
               * El ratio que especifica si se quiere reproducir más rápido o más lento. Para que
                 se reproduzca a la velocidad normal el valor es 0.
         */
        sp.play(sonido_de_Reproduccion, 1, 1, 1, 0,0);

    }

    public void audioMediaPlayer(View view){

        // Creo un objeto de tipo MediaPlayer al que le doy como parámetros el contexto y el id del audio.
        MediaPlayer mp = MediaPlayer.create(this,R.raw.paranoid);
        //Reproduzco el audio
        mp.start();

    }

}
