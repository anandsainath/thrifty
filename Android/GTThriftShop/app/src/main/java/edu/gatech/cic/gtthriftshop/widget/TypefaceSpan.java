package edu.gatech.cic.gtthriftshop.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.util.LruCache;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/**
 * Style a {@link android.text.Spannable} with a custom {@link android.graphics.Typeface}.
 * 
 * @author Tristan Waddington
 */
public class TypefaceSpan extends MetricAffectingSpan {
	/** An <code>LruCache</code> for previously loaded typefaces. */
	private static LruCache<String, Typeface> sTypefaceCache = new LruCache<String, Typeface>(2);

	private Typeface mTypeface;

	/**
	 * Load the {@link android.graphics.Typeface} and apply to a {@link android.text.Spannable}.
	 */
	public TypefaceSpan(Context context, String typefaceName) {
		mTypeface = sTypefaceCache.get(typefaceName);

		if (mTypeface == null) {
			mTypeface = Typeface.createFromAsset(context.getApplicationContext().getAssets(), typefaceName);
			sTypefaceCache.put(typefaceName, mTypeface);
		}
	}

	/**
	 * Load the {@link android.graphics.Typeface} and apply to a {@link android.text.Spannable}.
	 */
	public TypefaceSpan(Context context) {
		String typefaceName = "Aller.ttf";
		mTypeface = sTypefaceCache.get(typefaceName);

		if (mTypeface == null) {
			mTypeface = Typeface.createFromAsset(context.getApplicationContext().getAssets(), typefaceName);
			sTypefaceCache.put(typefaceName, mTypeface);
		}
	}

	@Override
	public void updateMeasureState(TextPaint p) {
		p.setTypeface(mTypeface);
	}

	@Override
	public void updateDrawState(TextPaint tp) {
		tp.setTypeface(mTypeface);
	}
}