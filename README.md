# SuperBindView
一个通过注解绑定View的 框架，支持简单的view绑定从而替代了传统的findviewbyid，也支持点击事件的设置，核心思想就是仿造有名的butterknife框架的apt思想
# 如何引用
在allprojects 里面 maven { url 'https://jitpack.io' }在项目的build.gradle里面增加 implementation 'com.github.preqel:SuperBindView:1.0' 的依赖

# 具体说明
1.注解 @BindView
作用等同于findviewbyid
2.注解 @setText
作用相当于settext
3.注解 @ OnClick
设置点击事件
