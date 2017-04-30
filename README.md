# ProProgressViews
Android library with collection of amazing progress views.

## DEMO 
<img src="https://github.com/DamanSingh4321/ProProgressViews/blob/master/app/screenshot.gif?raw=true" width="250">
<br><br>

## Mentions

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-ProProgressViews-blue.svg?style=flat)](https://android-arsenal.com/details/1/5454)

<ul>
    <li><a href="https://material.uplabs.com/posts/proprogressviews">MaterialUp</a></li>
    <li><a href="https://android.libhunt.com/project/proprogressviews">Android Library Hunt</a></li>
</ul>

## DOWNLOAD
<p>Add this to your root <code>build.gradle</code> file</p>

<pre><code>allprojects {
        repositories {
            ...
            maven { url "https://jitpack.io" }
        }
    }
</code></pre>

<p>Add this to your app module's <code>build.gradle</code> file</p>

<pre><code>dependencies {
             compile 'com.github.DamanSingh4321:ProProgressViews:v1.0'
    }
</code></pre>
<br><br>
According to above DEMO:-
<br><p><strong>Row 1</strong></p>
<ul>
<li><code>DoubleArcProgress</code></li>
<li><code>DottedArcProgress</code></li>
</ul>
<br><p><strong>Row 2</strong></p>
<ul>
<li><code>CircleLineProgress</code></li>
<li><code>CicleArcProgress</code></li>
</ul>

## USAGE
<p>In your Layout XML add this (all the app:.... attributes are optional and have default values
<p><b>For DoubleArcProgress</b></p>
<pre><code>    &lt;com.singh.daman.proprogressviews.DoubleArcProgress
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:arcRadius="30dp"
        app:colorofArc="@android:color/holo_red_dark"
        /&gt;
</code></pre>
<table>
<tr>
<th>Property</th>
<th>Description</th>
<th>Format</th>
<th>Default</th>
</tr>
<tr>
<td>arcRadius</td>
<td>Radius of the arcs</td>
<td>dimension</td>
<td>50dp</td>
</tr>
<tr>
<td>colorofArc</td>
<td>Color of the arcs.</td>
<td>color</td>
<td>#b0dbdb</td>
</tr>
<tr>
</table>
<br><br>

<p><b>For DottedArcProgress</b></p>
<pre><code>    &lt;com.singh.daman.proprogressviews.DottedArcProgress
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:dots_radius="30dp"
        app:dots_color="@android:color/holo_red_dark"
        /&gt;
</code></pre>
<table>
<tr>
<th>Property</th>
<th>Description</th>
<th>Format</th>
<th>Default</th>
</tr>
<tr>
<td>dots_radius</td>
<td>Radius of the dotted arc</td>
<td>dimension</td>
<td>50dp</td>
</tr>
<tr>
<td>dots_color</td>
<td>Color of the dotted arc.</td>
<td>color</td>
<td>#009688</td>
</tr>
</table>
<br><br>

<p><b>For CircleLineProgress</b></p>
<pre><code>    &lt;com.singh.daman.proprogressviews.CircleLineProgress
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
         app:circle_radius="30dp"
        app:circle_color="@android:color/holo_red_dark"
         app:line_radius="30dp"      
        app:line_color="@android:color/holo_red_dark"
        /&gt;
</code></pre>
<table>
<tr>
<th>Property</th>
<th>Description</th>
<th>Format</th>
<th>Default</th>
</tr>
<tr>
<td>circle_radius</td>
<td>Radius of circle.</td>
<td>dimension</td>
<td>50dp</td>
</tr>
<tr>
<td>circle_color</td>
<td>Color of circle.</td>
<td>color</td>
<td>#efbd63</td>
</tr>
<tr>
<td>line_radius</td>
<td>Radius of line.</td>
<td>dimension</td>
<td>50dp</td>
</tr>
<tr>
<td>line_color</td>
<td>Color of line.</td>
<td>color</td>
<td>#ef5a84</td>
</tr>
</table>
<br><br>


<p><b>For CircleArcProgress</b></p>
<pre><code>    &lt;com.singh.daman.proprogressviews.CircleArcProgress
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:circle_size="30dp"
        app:color_circle="@android:color/holo_red_dark"
        app:arc_radius="50dp"
        app:arc_color="@android:color/holo_red_dark"
        /&gt;
</code></pre>
<table>
<tr>
<th>Property</th>
<th>Description</th>
<th>Format</th>
<th>Default</th>
</tr>
<tr>
<td>circle_size</td>
<td>Radius of circle.</td>
<td>dimension</td>
<td>5dp</td>
</tr>
<tr>
<td>color_circle</td>
<td>Color of circle.</td>
<td>color</td>
<td>#009688</td>
</tr>
<tr>
<td>arc_radius</td>
<td>Radius of arc.</td>
<td>dimension</td>
<td>50dp</td>
</tr>
<tr>
<td>arc_color</td>
<td>Color of arc.</td>
<td>color</td>
<td>#009688</td>
</tr>
</table>

<br><br>
## DEVELOPERS
<a href="https://github.com/damansingh4321">Damanpreet Singh</a>
<br><br>
## LICENSE
<br>
<pre><code>Copyright 2017 Damanpreet Singh

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

</code></pre>
