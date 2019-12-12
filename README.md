# Glide_VS_Picasso
网上各种Glide和Picasso的对比都是很久之前的了，功能方面肯定有一定偏差，现在基于各自最新版本做一次性能对比
**Glide:4.10.0 VS Picasso:2.71828**

**配置方面**
1.Glide默认配置是有磁盘缓存的 在data/data/应用包名/cache/image_manager_disk_cache下
2.Glide默认缓存图片是原图
3.Picasso默认不缓存图片，默认不支持https，需要配置

**内存使用方面**
1.单张本地大图（12.2M，尺寸3456*4608）内存堆栈信息如下

Glide单张大图(ARGB8888)

![Glide单张大图(ARGB8888).png](https://upload-images.jianshu.io/upload_images/14014812-1cacb52cd9b90abb.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Glide单张大图内存情况(默认配置)

![Glide单张大图内存情况(默认配置).png](https://upload-images.jianshu.io/upload_images/14014812-e810d62828cc5de2.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Picasso单张大图内存情况

![Picasso单张大图内存情况.png](https://upload-images.jianshu.io/upload_images/14014812-4bc991a5bf2009b0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


**结论：
无论Glide使用默认的RGB_565还是ARGB8888都比Picasso节省内存，而且Glide的RGB_565和ARGB8888内存使用情况竟然差不多**

2.测试多张大图列表快速滑动内存的使用情况（图片大小1-16M，共计25张）
![Glide(设置ImageView match_parent列表滚动内存情况.png](https://upload-images.jianshu.io/upload_images/14014812-a413fdeece04eb55.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![Glide(设置ImageView wrap_content)滑动内存情况.png](https://upload-images.jianshu.io/upload_images/14014812-01722193b098ff68.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![Picasso默认配置(ImageView 500dp)列表滑动内存使用情况.png](https://upload-images.jianshu.io/upload_images/14014812-ea39c177d1d31f13.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![Picasso默认配置(ImageView match_parent)列表滑动内存使用情况.png](https://upload-images.jianshu.io/upload_images/14014812-53b27b51214da85b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![Picasso默认配置(ImageView warp_content)列表滑动内存使用情况.png](https://upload-images.jianshu.io/upload_images/14014812-64addd81508cc9de.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![Picasso默认配置(Picasso设置大小4000）列表滑动内存使用情况.png](https://upload-images.jianshu.io/upload_images/14014812-6e7c7e7d82eacb97.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

![Picasso默认配置(Picasso设置大小为1000）列表滑动内存使用情况.png](https://upload-images.jianshu.io/upload_images/14014812-7a702c4e82bb8c09.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**结论ImageView 使用warp_content两个框架消耗内存巨大，且界面卡顿
Picasso在使用非固定大小或者固定大小较大时内存消耗也都很大，Glide在各种情况上内存使用还是要优于Picasso的**
