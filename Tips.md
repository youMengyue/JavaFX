## 1. 在IDEA中创建JavaFX项目时候依靠Maven依赖项生成，导入第三方包时会无法识别，需要在项目的pom.xml文件中加入以下代码

---

```html
<plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                    <compilerArguments>
                        <extdirs>${project.basedir}/lib</extdirs>
                    </compilerArguments>
                </configuration>
            </plugin>
```



