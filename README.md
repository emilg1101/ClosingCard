# ClosingCard

![alt text](https://raw.githubusercontent.com/emilg1101/ClosingCard/master/screenshots/screenshot1.jpg)

Gradle
------
```
dependencies {
    ...
    compile 'com.android.support:cardview-v7:27.0.2'
    compile 'com.github:closingcard:0.0.1-beta'
}
```

Usage
-----

```
ClosingCard card = (ClosingCard) findViewById(R.id.card);

card = card.newBuilder()
        .setCornerRadius(35f)
        .setTitle("Personal information")
        .setButton("Next", new ClosingCard.OnButtonClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "Next", Toast.LENGTH_SHORT).show();
            }
        })
        .setOnCloseListener(new ClosingCard.OnCloseListener() {
            @Override
            public void onClose(View view) {
                Toast.makeText(MainActivity.this, "Close", Toast.LENGTH_SHORT).show();
            }
        })
        .build();
```

Changelog
---------
* **0.0.1-beta**
  * Initial beta
  
License
-------
  
```
  MIT License

  Copyright (c) 2018 Emil Gafiyatullin

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in all
  copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
  SOFTWARE.
```