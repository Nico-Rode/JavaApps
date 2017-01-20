package edu.whitworth.yahtzee;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Integer[] arrayOfImages = new Integer[6];
    public ImageView[] arrayOfView = new ImageView[6];
    public ImageView iv1;
    public ImageView iv2;
    public ImageView iv3;
    public ImageView iv4;
    public ImageView iv5;
    public ImageView iv6;
    public Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                    for (int p = 0; p < 6; p++) {
                        changeImage(arrayOfView[p]);
                    }
                    try {Thread.sleep(100);}
                    catch (Exception ex){;}
                }
        });
    }


    public void changeImage(ImageView iv)
    {
        iv.setImageResource(arrayOfImages[rnd.nextInt(6)]);

    }

    public void initialize()
    {
        iv1= (ImageView)findViewById(R.id.imageView1);
        iv2 = (ImageView)findViewById(R.id.imageView2);
        iv3 = (ImageView)findViewById(R.id.imageView3);
        iv4 = (ImageView)findViewById(R.id.imageView4);
        iv5 = (ImageView)findViewById(R.id.imageView5);
        iv6 = (ImageView)findViewById(R.id.imageView6);


        arrayOfImages[0] = R.drawable.dice1;
        arrayOfImages[1] = R.drawable.dice2;
        arrayOfImages[2] = R.drawable.dice3;
        arrayOfImages[3] = R.drawable.dice4;
        arrayOfImages[4] = R.drawable.dice5;
        arrayOfImages[5] = R.drawable.dice6;


        arrayOfView[0] = iv1;
        arrayOfView[1] = iv2;
        arrayOfView[2] = iv3;
        arrayOfView[3] = iv4;
        arrayOfView[4] = iv5;
        arrayOfView[5] = iv6;


        for (int i = 0; i < 6; i++)
            arrayOfView[i].setImageResource(arrayOfImages[rnd.nextInt(6)]);

    }
}

class Dice implements Runnable
{
    private ImageView iv;
    public Integer[] arrayOfImages = new Integer[6];

    public Dice(ImageView iv, Integer[] array)
    {
        this.iv = iv;
        for (int i = 0; i < 6; i++)
        {
            arrayOfImages[i] = array[i];
        }

    }

    public void run()
    {
        Random rand = new Random();
        int n = rand.nextInt(6);


    }

}
