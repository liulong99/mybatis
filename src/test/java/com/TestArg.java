/**
 *    Copyright 2009-2019 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestArg {
      public void test(String name,String age){

      }

  public static void main(String[] args) throws Exception{
    Method test = TestArg.class.getMethod("test", String.class, String.class);
    for (Parameter parameter : test.getParameters()) {
      System.out.println(parameter.getName());
    }

  }
}
