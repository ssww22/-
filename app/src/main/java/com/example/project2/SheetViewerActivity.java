package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SheetViewerActivity extends AppCompatActivity {


    String sheet_id;
    String songName;
    String singer;
    Button button;
    LinearLayout scoreLayout;
    private List<TextView> textViewList;
    private List<MyObject> objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sheet1);

        Intent intent = getIntent();
        String songName = intent.getStringExtra("song_name");
        String singer = intent.getStringExtra("singer");
        //TextView의 개수

        registerObjects();
        textViewList = new ArrayList<>();


        Button upButton = (Button) findViewById(R.id.upKey);
        Button downButton = (Button) findViewById(R.id.downKey);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateTextViewCodes();

            }
        });
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseKey();
            }
        });

    }

    //TextView 개수를 세는 메소드


    private void registerObjects() {
        objects.clear();
        int i = 1;
        while (true) {
            int resId = getResources().getIdentifier("code" + i, "id", getPackageName());
            if (resId == 0) {
                break; // 더 이상 ID를 찾을 수 없을 때 루프 종료
            }
            TextView textView = findViewById(resId);
            if (textView != null) {
                objects.add(new MyObject(textView));
            }
            i++;
        }
    }

    // 예시 객체 클래스
    private class MyObject {
        private TextView textView;

        public MyObject(TextView textView) {
            this.textView = textView;
        }

        // 기타 메소드 및 로직 추가
    }

    private void updateTextViewCodes() {
        for (TextView textView : textViewList) {
            String currentText = textView.getText().toString();
            String newText = getNextCode(currentText);
            textView.setText(newText);
        }

    }

    // 현재 코드에 대한 다음 코드를 반환하는 메소드
    private String getNextCode(String currentCode) {
        if (currentCode.equals("C")) {
            return "C#";
        } else if (currentCode.equals("C#")) {
            return "D";
        } else if (currentCode.equals("D")) {
            return "D#";
        } else if (currentCode.equals("D#")) {
            return "E";
        } else if (currentCode.equals("E")) {
            return "F";
        } else if (currentCode.equals("F")) {
            return "F#";
        } else if (currentCode.equals("F#")) {
            return "G";
        } else if (currentCode.equals("G")) {
            return "G#";
        } else if (currentCode.equals("G#")) {
            return "A";
        } else if (currentCode.equals("A")) {
            return "A#";
        } else if (currentCode.equals("A#")) {
            return "B";
        } else if (currentCode.equals("B")) {
            return "C";
            // 마이너 코드
        } else if (currentCode.equals("Cm")) {
            return "C#m";
        } else if (currentCode.equals("C#m")) {
            return "Dm";
        } else if (currentCode.equals("Dm")) {
            return "D#m";
        } else if (currentCode.equals("D#m")) {
            return "Em";
        } else if (currentCode.equals("Em")) {
            return "Fm";
        } else if (currentCode.equals("Fm")) {
            return "F#m";
        } else if (currentCode.equals("F#m")) {
            return "Gm";
        } else if (currentCode.equals("Gm")) {
            return "G#m";
        } else if (currentCode.equals("G#m")) {
            return "Am";
        } else if (currentCode.equals("Am")) {
            return "A#m";
        } else if (currentCode.equals("A#m")) {
            return "Bm";
        } else if (currentCode.equals("Bm")) {
            return "Cm";
            // 도미넌트 코드
        } else if (currentCode.equals("C7")) {
            return "C#7";
        } else if (currentCode.equals("C#7")) {
            return "D7";
        } else if (currentCode.equals("D7")) {
            return "D#7";
        } else if (currentCode.equals("D#7")) {
            return "E7";
        } else if (currentCode.equals("E7")) {
            return "F7";
        } else if (currentCode.equals("F7")) {
            return "F#7";
        } else if (currentCode.equals("F#7")) {
            return "G7";
        } else if (currentCode.equals("G7")) {
            return "G#7";
        } else if (currentCode.equals("G#7")) {
            return "A7";
        } else if (currentCode.equals("A7")) {
            return "A#7";
        } else if (currentCode.equals("A#7")) {
            return "B7";
        } else if (currentCode.equals("B7")) {
            return "C7";
            // 세븐스 코드
        } else if (currentCode.equals("Cmaj7")) {
            return "C#maj7";
        } else if (currentCode.equals("C#maj7")) {
            return "Dmaj7";
        } else if (currentCode.equals("Dmaj7")) {
            return "D#maj7";
        } else if (currentCode.equals("D#maj7")) {
            return "Emaj7";
        } else if (currentCode.equals("Emaj7")) {
            return "Fmaj7";
        } else if (currentCode.equals("Fmaj7")) {
            return "F#maj7";
        } else if (currentCode.equals("F#maj7")) {
            return "Gmaj7";
        } else if (currentCode.equals("Gmaj7")) {
            return "G#maj7";
        } else if (currentCode.equals("G#maj7")) {
            return "Amaj7";
        } else if (currentCode.equals("Amaj7")) {
            return "A#maj7";
        } else if (currentCode.equals("A#maj7")) {
            return "Bmaj7";
        } else if (currentCode.equals("Bmaj7")) {
            return "Cmaj7";
        }
        return currentCode;
    }

    private void decreaseKey() {
        for (TextView textView : textViewList) {
            String currentText = textView.getText().toString();
            String newText = getPreviousCode(currentText);
            textView.setText(newText);
        }

    }

    // 현재 코드에 대한 이전 코드를 반환하는 메소드
    private String getPreviousCode(String currentCode) {
        switch (currentCode) {
            case "C":
                return "B";
            case "C#":
                return "C";
            case "D":
                return "C#";
            case "D#":
                return "D";
            case "E":
                return "D#";
            case "F":
                return "E";
            case "F#":
                return "F";
            case "G":
                return "F#";
            case "G#":
                return "G";
            case "A":
                return "G#";
            case "A#":
                return "A";
            case "B":
                return "A#";
            // 마이너 코드
            case "Cm":
                return "B";
            case "C#m":
                return "Cm";
            case "Dm":
                return "C#m";
            case "D#m":
                return "Dm";
            case "Em":
                return "D#m";
            case "Fm":
                return "Em";
            case "F#m":
                return "Fm";
            case "Gm":
                return "F#m";
            case "G#m":
                return "Gm";
            case "Am":
                return "G#m";
            case "A#m":
                return "Am";
            case "Bm":
                return "A#m";
            // 도미넌트 코드
            case "C7":
                return "B7";
            case "C#7":
                return "C7";
            case "D7":
                return "C#7";
            case "D#7":
                return "D7";
            case "E7":
                return "D#7";
            case "F7":
                return "E7";
            case "F#7":
                return "F7";
            case "G7":
                return "F#7";
            case "G#7":
                return "G7";
            case "A7":
                return "G#7";
            case "A#7":
                return "A7";
            case "B7":
                return "A#7";
            // 세븐스 코드
            case "Cmaj7":
                return "Bmaj7";
            case "C#maj7":
                return "Cmaj7";
            case "Dmaj7":
                return "C#maj7";
            case "D#maj7":
                return "Dmaj7";
            case "Emaj7":
                return "D#maj7";
            case "Fmaj7":
                return "Emaj7";
            case "F#maj7":
                return "Fmaj7";
            case "Gmaj7":
                return "F#maj7";
            case "G#maj7":
                return "Gmaj7";
            case "Amaj7":
                return "G#maj7";
            case "A#maj7":
                return "Amaj7";
            case "Bmaj7":
                return "A#maj7";
            default:
                return currentCode;
        }
    }
}
