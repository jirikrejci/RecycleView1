package com.example.jirka.recycleview.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.jirka.recycleview.R;

public class actDetailActivity extends AppCompatActivity {

    private static final String BUNDLE_EXTRAS = "BUNDLE_EXTRAS";
    private static final String EXTRA_QUOTE = "EXTRA_QUOTE";
    private static final String EXTRA_ATTR = "EXTRA_ATTR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras().getBundle (BUNDLE_EXTRAS);
        TextView tvQuote = (TextView) findViewById(R.id.lbl_quote);
        tvQuote.setText(bundle.getString(EXTRA_QUOTE));

        //  přímější volání, bez uloženého ohandle na lbl_quote
        ((TextView) findViewById(R.id.lbl_quote_attribution)).setText(bundle.getString(EXTRA_ATTR));
    }
}
