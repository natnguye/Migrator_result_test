

package com.adventure.game;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BuildConfig {

    private static final Logger logger = Logger.getLogger(BuildConfig.class.getName());

    static {
        try {
            FileHandler fileHandler = new FileHandler("build.log", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            logger.severe("Error initializing logger: " + e.getMessage());
        }
    }

    public void configureBuild(Model model) {
        model.setGroupId("com.adventure.game");
        model.setArtifactId("adventure-game");
        model.setVersion("1.0-SNAPSHOT");
        model.setPackaging("jar");

        model.addDependency("org.springframework.boot", "spring-boot-starter-web", "2.3.4.RELEASE");
        model.addDependency("org.springframework.boot", "spring-boot-starter-data-jpa", "2.3.4.RELEASE");
        model.addDependency("com.h2database", "h2", "1.4.200", "runtime");
        model.addDependency("org.springframework.boot", "spring-boot-starter-test", "2.3.4.RELEASE", "test");

        model.addPlugin("org.apache.maven.plugins", "maven-compiler-plugin", "3.8.1");
        model.addPlugin("org.apache.maven.plugins", "maven-jar-plugin", "3.2.0");
    }

    public void writePomFile(Model model) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("pom.xml"))) {
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
            writer.println("         xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
            writer.println("    <groupId>" + model.getGroupId() + "</groupId>");
            writer.println("    <artifactId>" + model.getArtifactId() + "</artifactId>");
            writer.println("    <version>" + model.getVersion() + "</version>");
            writer.println("    <packaging>" + model.getPackaging() + "</packaging>");
            writer.println();
            writer.println("    <dependencies>");
            for (org.apache.maven.model.Dependency dependency : model.getDependencies()) {
                writer.println("        <dependency>");
                writer.println("            <groupId>" + dependency.getGroupId() + "</groupId>");
                writer.println("            <artifactId>" + dependency.getArtifactId() + "</artifactId>");
                writer.println("            <version>" + dependency.getVersion() + "</version>");
                if (dependency.getScope() != null) {
                    writer.println("            <scope>" + dependency.getScope() + "</scope>");
                }
                writer.println("        </dependency>");
            }
            writer.println("    </dependencies>");
            writer.println();
            writer.println("    <build>");
            writer.println("        <plugins>");
            for (org.apache.maven.model.Plugin plugin : model.getBuild().getPlugins()) {
                writer.println("            <plugin>");
                writer.println("                <groupId>" + plugin.getGroupId() + "</groupId>");
                writer.println("                <artifactId>" + plugin.getArtifactId() + "</artifactId>");
                writer.println("                <version>" + plugin.getVersion() + "</version>");
                writer.println("            </plugin>");
            }
            writer.println("        </plugins>");
            writer.println("    </build>");
            writer.println("</project>");
            logger.info("POM file written successfully");
        } catch (IOException e) {
            logger.severe("Error writing POM file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean buildProject() {
        try {
            Process process = Runtime.getRuntime().exec("mvn clean package");
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                logger.info("Build successful");
                return true;
            } else {
                logger.severe("Build failed with exit code " + exitCode);
                return false;
            }
        } catch (IOException | InterruptedException e) {
            logger.severe("Error building project: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        BuildConfig buildConfig = new BuildConfig();
        Model model = new Model();
        buildConfig.configureBuild(model);
        buildConfig.writePomFile(model);
        buildConfig.buildProject();
    }
}