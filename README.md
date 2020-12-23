# Athenaeum - 1.0
**Description:** Simple and easy to use library for bukkit plugins!

**Current version:** 1.0

**2020-2021 Roadmap:**
> Bukkit module:
> > General features:
> > 1. Add GUI builder basing on chars.
> > 2. Add command builder without switch/case or else/if blocks.
> > 3. Add item builder.
> > 4. Add mob builder.
> > 5. Message builder.
> > 
> > Misc features:
> > 1. Add BossBar builder.
> > 2. Add Scoreboard builder.
> > 3. Add Hologram builder.

### NOT IMPLEMENTED

**Maven dependencies:**
> ```xml
> <repositories>
>       <repository>
>	          <id>athenaeum-repo</id>
>           <url>https://repo.codemc.org/repository/athenaeum/</url>
>       </repository>
> </repositories>
> 
> <dependency>
>	        <groupId>com.athenaeum</groupId>
>		<artifactId>[library-part]</artifactId>
>	        <version>[part-version]</version>
> </dependency>
> ```

**Gradle dependencies:**
> ```groovy
> repositories {
>     maven { url = "https://repo.codemc.org/repository/athenaeum/" }
> }
> 
> dependencies {
>     implementation("com.athenaeum:[library-part]:[part-version]")
> }
> ```

**Maven implementation:**
> ```xml
> <plugin>
>     <groupId>org.apache.maven.plugins</groupId>
>     <artifactId>maven-shade-plugin</artifactId>
>     <version>3.1.1</version>
>     <configuration>
>         <relocations>
>             <relocation>
>                 <pattern>com.athenaeum</pattern>
>                 <shadedPattern>[own-plugin-group].library</shadedPattern>
>             </relocation>
>         </relocations>
>     </configuration>
>     <executions>
>         <execution>
>             <phase>package</phase>
>             <goals>
>                 <goal>shade</goal>
>             </goals>
>         </execution>
>     </executions>
> </plugin>
> ```

**Gradle implementation:**
> ```groovy
> apply plugin: 'com.github.johnrengelman.shadow'
>
> shadowJar {
>     relocate 'com.athenaeum', '[own-plugin-group].library'
> }
> ```