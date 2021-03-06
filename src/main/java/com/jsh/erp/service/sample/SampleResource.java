package com.jsh.erp.service.sample;

import com.jsh.erp.service.ResourceInfo;

import java.lang.annotation.*;

@ResourceInfo(value = "sample")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SampleResource {
}
