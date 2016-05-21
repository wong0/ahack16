import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import angelhack.com.myapplication.R;


/**
 * Standard TextView used to unify all assets.fonts.
 */
public class Text extends TextView {

    public Text(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public Text(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public Text(Context context) {
        super(context);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Text);
            Integer fontStyle = a.getInt(0, R.styleable.Text_android_textStyle);
            String fontName= "assets/fonts/proximanova-regular-webfont.otf";

            switch (fontStyle) {
                case Typeface.NORMAL:
                    fontName = "assets/fonts/proximanova-regular-webfont.otf";
                    break;

                case Typeface.BOLD:
                    fontName = "assets/fonts/proximanova-regular-webfont.otf";
                    break;

                case Typeface.BOLD_ITALIC:
                    fontName = "assets/fonts/proximanova-regular-webfont.otf";
                    break;

                case Typeface.ITALIC:
                    fontName = "assets/fonts/proximanova-regular-webfont.otf";
                    break;
            }

            setTypeface(Typeface.createFromAsset(getContext().getAssets(), fontName));
            a.recycle();
        }
    }

}

