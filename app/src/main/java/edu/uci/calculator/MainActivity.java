package edu.uci.calculator;

import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String input = "";
    String output = "";
    String out = "";
    String [] valuesbuffer = new String [ 20 ];
    char [] operationsbuffer = new char [ 20 ];
    boolean percentflag = false;
    char tracker = '\0';
    char operator = 'a';
    double ans = 0.0;

    @Override
    protected void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void clearScreen ( View view )
    {
        TextView textView = ( TextView ) findViewById ( R.id.textView2 );
        textView.setText( " " );
    }

    public void toScreen ( String display )
    {
        TextView textView = ( TextView ) findViewById( R.id.textView2 );
        textView.setText ( display );
    }

    public void Append9 ( View view )
    {
        tracker = '\0';
        input = input + "9";
        toScreen( input );
    }

    public void Append8 ( View view )
    {
        tracker = '\0';
        input = input + "8";
        toScreen( input );
    }

    public void Append7 ( View view )
    {
        tracker = '\0';
        input = input + "7";
        toScreen( input );
    }

    public void Append6 ( View view )
    {
        tracker = '\0';
        input = input + "6";
        toScreen( input );
    }

    public void Append5 ( View view )
    {
        tracker = '\0';
        input = input + "5";
        toScreen( input );
    }

    public void Append4 ( View view )
    {
        tracker = '\0';
        input = input + "4";
        toScreen( input );
    }

    public void Append3 ( View view )
    {
        tracker = '\0';
        input = input + "3";
        toScreen( input );
    }

    public void Append2 ( View view )
    {
        tracker = '\0';
        input = input + "2";
        toScreen( input );
    }

    public void Append1 ( View view )
    {
        tracker = '\0';
        input = input + "1";
        toScreen( input );
    }

    public void Append0 ( View view )
    {
        tracker = '\0';
        input = input + "0";
        toScreen( input );
    }

    public void Appenddecimal ( View view )
    {
        if ( tracker == '.' ) { return; }
        tracker = '.';
        input = input + ".";
        toScreen( input );
    }

    public void Appendd ( View view )
    {
        if ( tracker == '/' || tracker == 'x' || tracker == '-' || tracker == '+' || tracker == '.' ) { return; }
        tracker = '/';
        input = input + "/";
        toScreen( input );
    }
    public void Appendx ( View view )
    {
        if ( tracker == '/' || tracker == 'x' || tracker == '-' || tracker == '+' || tracker == '.' ) { return; }
        tracker = 'x';
        input = input + "x";
        toScreen( input );
    }
    public void Appends ( View view )
    {
        if ( tracker == '/' || tracker == 'x' || tracker == '-' || tracker == '+' || tracker == '.' ) { return; }
        tracker = '-';
        input = input + "-";
        toScreen( input );
    }
    public void Appenda ( View view )
    {
        if ( tracker == '/' || tracker == 'x' || tracker == '-' || tracker == '+' || tracker == '.' ) { return; }
        tracker = '+';
        input = input + "+";
        toScreen( input );
    }

    public void Percent ( View view ){
        double value;
        boolean flag = true;

        if ( input == "" ) { input = output; }
        for ( int i = 0; i < input.length(); i++ )
        {
            if ( (input.charAt ( i ) == 'x' ||
                 input.charAt ( i ) == '/' ||
                 input.charAt ( i ) == '+' ||
                 input.charAt ( i ) == '-' ) &&
                         (
                         input.charAt ( 0 ) != 'x' ||
                    input.charAt ( 0 ) != '/' ||
                    input.charAt ( 0 ) != '+' ||
                    input.charAt ( 0 ) != '-') &&
                            ( input.charAt ( input.length() - 1 ) != 'x' ||
                    input.charAt ( input.length() - 1 ) != '/' ||
                    input.charAt ( input.length() - 1 ) != '+' ||
                    input.charAt ( input.length() - 1 ) != '-')
                    )
            {
                flag = false;
            }
        }

        if ( flag )
        {
            value = Double.parseDouble( input );
            value = value / 100;
            output = Double.toString( value );
            toScreen ( output );
            percentflag = false;
            tracker = '\0';
            input = output;
           // output = "";
            return;
        }

        percentflag = true;
        Evaluate( view );
    }

    public void Delete ( View view )
    {
        //tracker = input.charAt( input.length() - 1 );
        if ( input == "" ) { return; }
        input = input.substring( 0, input.length() - 1 );
        toScreen( input );
        tracker = '\0';
    }

    public void ClearAll ( View view )
    {
        input = "";
        output = "";
        toScreen( input );
    }

    public void Evaluate ( View view )
    {
        valuesbuffer = input.split ( "-|x|/|\\+" );
        int n = 0;
        ArrayList < Double > values;
        ArrayList < Character > operations;
        operations = new ArrayList < Character >();
        values = new ArrayList < Double > ();
        Double temp;
        char op;
        boolean flag = true;
        int counter = 0;

        if ( input == "" ) { input = output; }

        if ( input.charAt( 0 ) == 'x' || input.charAt( 0 ) == '-'
                || input.charAt ( 0 ) == '+' || input.charAt( 0 ) == '/' ||
                input.charAt( input.length() - 1 ) == 'x' || input.charAt( input.length() - 1 ) == '-'
                || input.charAt ( input.length() - 1 ) == '+'
                || input.charAt( input.length() - 1 ) == '/' )
        {    toScreen ( "INVALID SYNTAX!" );
        return;}


        for ( int i = 0; i < input.length(); i++ )
        {
            if ( (input.charAt ( i ) == 'x' ||
                    input.charAt ( i ) == '/' ||
                    input.charAt ( i ) == '+' ||
                    input.charAt ( i ) == '-' ) &&
                    (
                            input.charAt ( 0 ) != 'x' ||
                                    input.charAt ( 0 ) != '/' ||
                                    input.charAt ( 0 ) != '+' ||
                                    input.charAt ( 0 ) != '-') &&
                    ( input.charAt ( input.length() - 1 ) != 'x' ||
                            input.charAt ( input.length() - 1 ) != '/' ||
                            input.charAt ( input.length() - 1 ) != '+' ||
                            input.charAt ( input.length() - 1 ) != '-')
                    )
            {
                flag = false;
            }
        }

        if ( flag )
        {
            output = input;
            toScreen( output );
            return;
        }

        for ( int i = 0; i < valuesbuffer.length; i++ )
        {
            counter = 0;
            for ( int j = 0; j < valuesbuffer [ i ].length(); j++ )
            {
                if ( valuesbuffer [ i ].charAt( j ) == '.' )
                {
                    counter++;
                    if ( counter > 1)
                    {
                        toScreen("SYNTAX ERROR!");
                        return;
                    }
                }
            }
        }

        for ( int i = 0; i < valuesbuffer.length; i++ )
        {
            temp =  Double.parseDouble( valuesbuffer [ i ] );
            values.add( temp );
        }

        for ( int i = 0; i < input.length(); i++ )
        {
            if ( input.charAt ( i ) == 'x' ||
                    input.charAt ( i ) == '/' ||
                    input.charAt ( i ) == '+' ||
                    input.charAt ( i ) == '-' )
            {
                operationsbuffer [ n ] = input.charAt ( i );
                n++;
            }
        }
        for ( int i = 0; i < input.length(); i++ )
        {
            op = operationsbuffer [ i ];
            operations.add( op );
        }

        n = 0;
        while ( n < operations.size() )
        {
            if ( operations.get( n ) == 'x' ) {
                operator = 'x';
            }
            else if ( operations.get( n ) == '/') {
                operator = '/';
            }
            else
            {
                n++;
                continue;
            }

            if ( operator == 'x' )
            {
                temp = values.get ( n ) * values.get( n + 1 );
                values.set ( n , temp );
                values.remove( n + 1 );
                operations.remove( n );
            }
            if ( operator == '/' )
            {
                temp = values.get ( n ) / values.get( n + 1 );
                values.set ( n , temp );
                values.remove( n + 1 );
                operations.remove( n );
            }
            n = 0;
        }

        n = 0;
        while( n < operations.size() )
        {
            if ( operations.get( n ).equals('+') ) {
                operator = '+';
            }
            else if ( operations.get( n ).equals('-') ) {
                operator = '-';
            }
            else
            {
                n++;
                continue;
            }

            if ( operator == '+' )
            {
                temp = values.get ( n ) + values.get( n + 1 );
                values.set ( n , temp );
                values.remove( n + 1 );
                operations.remove( n );
            }
            if ( operator == '-' )
            {
                temp = values.get ( n ) - values.get( n + 1 );
                values.set ( n , temp );
                values.remove( n + 1 );
                operations.remove( n );
            }
            n = 0;
        }

        n = 0;
        ans = values.get(n);
        if ( percentflag )
        {
            ans = ans / 100;
        }

        output = Double.toString( ans );
        percentflag = false;
        toScreen( output );
        tracker = '\0';
        input = "";
        //output = "";
    }
}
