package edu.uci.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    char [] current_array = new char [ 15 ] ;
    String current = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toScreen ( String current )
    {
        TextView textView = ( TextView ) findViewById( R.id.textView2 );

        textView.setText ( current );
    }

    public void Append9 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "9";
        toScreen( current );
    }
    public void Append8 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "8";
        toScreen( current );
    }
    public void Append7 ( View view )
    {
        current = current + "7";
        toScreen( current );
    }
    public void Append6 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "6";
        toScreen( current );
    }
    public void Append5 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "5";
        toScreen( current );
    }
    public void Append4 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "4";
        toScreen( current );
    }
    public void Append3 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "3";
        toScreen( current );
    }
    public void Append2 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "2";
        toScreen( current );
    }
    public void Append1 ( View view )
    {
        current = current + "1";
        toScreen( current );
    }
    public void Append0 ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "0";
        toScreen( current );
    }
    public void Appendd ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "/";
        toScreen( current );
    }
    public void Appendx ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "x";
        toScreen( current );
    }
    public void Appends ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "-";
        toScreen( current );
    }
    public void Appenda ( View view )
    {
        if ( current.length() == 15 ) { return; }
        current = current + "+";
        toScreen( current );
    }

    public void Percent ( View view ){}

    public void Delete ( View view )
    {

        int n = current.length();

        if ( n == 0 ) { return; }

        current_array = current.toCharArray();
        current_array [ n ] = '\0';
        current = current_array.toString();
        toScreen( current );

    }

    public void ClearAll ( View view )
    {
        current = "";
        toScreen( current );
    }

    public void Evaluate ( View view ) {
        double ans;
        double [] n = new double [ 15 ];
        String [] buffer = new String [ 15 ];
        char[] track = new char[ 15 ];

        if ( current.length() == 0 ) { return; }

        for (int i = 0; i < current.length(); i++)
        {
            if ( current.charAt(i) == '+' )
            {
                track [ i ] = '+';
            }

            if ( current.charAt(i) == '-' )
            {
                track [ i ] = '-';
            }

            if ( current.charAt(i) == '/' )
            {
                track [ i ] = '/';
            }

            if ( current.charAt(i) == 'x' )
            {
                track [ i ] = 'x';
            }

            else
            {
                track [ i ] = '0';
            }
        }

        //^^^^^^^^^^^^^^^^^^Good up there^^^^^^^^^^^^^^^

        buffer = current.split ( "[+-x/]+");
        for ( int i = 0; i < buffer.length; i++ )
            toScreen( buffer[ i ] );

        //current = buffer.toString();
        //toScreen( current );
        current_array = current.toCharArray();


        for ( int i = 0; i < buffer.length; i++ )
        {
            n [ i ] = (double) current_array [ i ];
        }

        current = n.toString();
       // toScreen( current );
    }
}
