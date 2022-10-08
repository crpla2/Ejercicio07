package com.example.ejercicio07;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

/**
 * Clase principal de la actividad donde inicializa la actividad y  se controlan
 * las acciones que se van a llevar a cabo.
 * @author DAM2Alu10
 * @version 1.0 Octubre 2022
 */
public class MainActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private LinearLayout ll;
    private Button b;
    int n=6;
       /**
     * Clase que almacena los datos de la actividad, sirve para colocar el código de inicialización.
     * Almacena la lógica básica de inicio de la aplicación que debería suceder solo una vez
     * durante toda la vida de la actividad.
     * @param savedInstanceState referencia a un objeto Bundle que se pasa al método.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout=findViewById(R.id.linearLayout);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        anadeLayouts();
    }
    /**
     * Clase que genera los layouts correspondientes para generar una cuadricula  donde
     * se añadirán los botones generados automáticamente mediante dos "For" anidados.
     */
    private void anadeLayouts() {
        int numBoton=1;
        for (int i = 0; i < n; i++) {
            ll=new LinearLayout(this);
            ll.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1));
            ll.setOrientation(LinearLayout.VERTICAL);
            ll.setId(View.generateViewId());

            for (int j = 0; j < n; j++) {
                b= new Button(this);
                b.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1));
                b.setBackgroundColor(colorAleatorio());
                b.setId(numBoton);
                b.setOnClickListener(this::onClick);
                ll.addView(b);
                numBoton++;
            }
            linearLayout.addView(ll);
        }
    }
    /**
     * Método que controla qué botón se ha pulsado.
     * @param view parámetro de tipo View que pertenece a la clase android.view.View.
     * Permite controlar la interacción de la aplicación con el usuario.
     * Cambia de botón los colores en función de cual ha sido pulsado:
     *      - Si es pulsado el último botón, cambia el color de todos los botones a un color
     *        generado de forma altatoria.
     *      - Si es pulsado cualquier otro de los "n" botones cambia el color del botón seleccionado.
     */
    public void onClick(View view){
        int color=colorAleatorio();
        if((n * n) == view.getId()) {
            for (int i = 0; i < n; i++) {
                LinearLayout aux = (LinearLayout) linearLayout.getChildAt(i);
                for (int j = 0; j < n; j++) {
                    aux.getChildAt(j).setBackgroundColor(color);
               }
           }
       } else view.setBackgroundColor(colorAleatorio());
    }
    /**
     * Método que genera un color de forma aleatoria.
     * @return int devuelve un entero (Color ints).
     * FUNCIONAMIENTO:
     * Crea un objeto "rnd" de la clase Random y mediante el método nextInt(255) genera números
     * aleatorios hasta el 255.
     * Llama al método estático "argb" de la Clase Color que recibe cuatro argumentos en
     * forma de entero(int) del rango [0-255], donde:
     *      - El primer argumento "Alpha" es el nivel de opacidad (fijado al máximo:255).
     *      - El segundo argumento "Red" el nivel de rojo (generado aleatoriamente).
     *      - El tercer argumento "Green" el nivel de verde (generado aleatoriamente).
     *      - El tercer argumento "Blue" el nivel de azul (generado aleatoriamente).
     */
    private int colorAleatorio() {
        Random rnd = new Random();
        return Color.argb(255,rnd.nextInt(255),
                                  rnd.nextInt(255),rnd.nextInt(255));
    }
}