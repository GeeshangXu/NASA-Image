/****************************************************************************
 Copyright (c) 2015 Geeshang Xu (Geeshangxu@gmail.com)

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 ****************************************************************************/
package geeshang.nasaimage;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.os.Bundle;
import android.widget.ImageView;


public class ImageOnlyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_only);
        ImageView largeImage = (ImageView) findViewById(R.id.id_large_image);
        Bundle bundle = getIntent().getExtras();
        byte[] imageBytes = bundle.getByteArray("large_image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        largeImage.setImageBitmap(bitmap);
        //Make the matrix image to be center of the screen.
        Point screen = new Point();
        getWindowManager().getDefaultDisplay().getSize(screen);
        int width = screen.x / 2 - bitmap.getWidth() / 2;
        int height = screen.y / 2 - bitmap.getHeight() / 2;
        Matrix matrix = new Matrix();
        matrix.postTranslate(width, height);
        largeImage.setImageMatrix(matrix);
        largeImage.setOnTouchListener(new ImageTransformHandler());
    }
}


