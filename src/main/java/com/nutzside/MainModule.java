package com.nutzside;

import org.nutz.mvc.annotation.By;
import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.Fail;
import org.nutz.mvc.annotation.Filters;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Localization;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.annotation.Views;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import com.nutzside.common.mvc.view.XJsonViewMaker;
import com.nutzside.system.shiro.ShiroActionFilter;

@Encoding(input="utf8",output="utf8")
@Modules(packages = { "com.wms","com.xcms" ,"com.nutzside"}, scanPackage = true)
@Ok("json")
@Fail("Xjson")
@IocBy(type = ComboIocProvider.class, args = {
		"*org.nutz.ioc.loader.json.JsonLoader", "ioc/",
		"*org.nutz.ioc.loader.annotation.AnnotationIocLoader", "com.nutzside","com.wms","com.xcms"})
@SetupBy(value = MvcSetup.class)
// 全局的Shiro注解过滤器
@Filters(@By(type = ShiroActionFilter.class, args = "/index.jsp"))
@Localization("msg")
@Views({XJsonViewMaker.class})
public class MainModule {

}