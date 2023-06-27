package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SourceFileReaderFacadeTest {

    @Test
    public void testReadFileIntoList_LocalFile_Success() throws IOException {
        // Arrange
        List<String> expectedContent = new ArrayList<>();
        expectedContent.add("public class Class1 {");
        expectedContent.add("\t\t// simple comment");
        expectedContent.add("// simple comment 2");
        expectedContent.add("");
        expectedContent.add(" /* long comment 1 */");
        expectedContent.add(" ");
        expectedContent.add(" /* ");
        expectedContent.add(" * ");
        expectedContent.add(" * long comment 2 ");
        expectedContent.add(" */");
        expectedContent.add("");
        expectedContent.add("\tpublic void foo() {}");
        expectedContent.add("");
        expectedContent.add("\tString foo2() {");
        expectedContent.add("\t\tint x = Math.pow(2,2);");
        expectedContent.add("\t}");
        expectedContent.add("}");
        expectedContent.add("");
        expectedContent.add("class Class2{");
        expectedContent.add("");
        expectedContent.add("\tstatic void foo3(){");
        expectedContent.add("");
        expectedContent.add("} ");
        expectedContent.add("");
        expectedContent.add("}");
        expectedContent.add("");
        expectedContent.add("class Class3 {");
        expectedContent.add("\t/***");
        expectedContent.add("\t*");
        expectedContent.add("\t* Javadoc comment");
        expectedContent.add("\t*/");
        expectedContent.add("}");

        String filepath = "src/test/resources/TestClass.java";
        String locationType = "local";
        SourceFileReaderFacade facade = new SourceFileReaderFacade();

        // Act
        List<String> actualContent = facade.readFileIntoList(filepath, locationType);

        // Assert
        Assert.assertEquals(expectedContent, actualContent);
    }

    @Test
    public void testReadFileIntoList_WebFile_Success() throws IOException {
        // Arrange
        List<String> expectedContent = new ArrayList<>();
        expectedContent.add("package main.game;");
        expectedContent.add("");
        expectedContent.add("import java.awt.*;");
        expectedContent.add("import java.awt.image.BufferedImage;");
        expectedContent.add("");
        expectedContent.add("//this class draws the animation in the screen");
        expectedContent.add("public class Animation {");
        expectedContent.add("    public int frames; // how many photos we have to change for the animation to be done");
        expectedContent.add("    public int speed; //the speed that we change the photos");
        expectedContent.add("    public int index = 0;");
        expectedContent.add("    public int count = 0;");
        expectedContent.add("    public BufferedImage[] images; //the images that are needed for the animation");
        expectedContent.add("    public BufferedImage currentImg;//used to refer to the current image while drawing the animation");
        expectedContent.add("");
        expectedContent.add("    //constructor that gets a list or a table of BufferedImage");
        expectedContent.add("    //its initializes the images table");
        expectedContent.add("    public Animation(int speed, BufferedImage... args) {");
        expectedContent.add("        images = new BufferedImage[args.length];");
        expectedContent.add("        //The speed will depend on how many images we have");
        expectedContent.add("        this.speed = 60 / args.length - speed; // bigger speed -> slower animation and vice versa");
        expectedContent.add("        //Copy args array into images:");
        expectedContent.add("        System.arraycopy(args, 0, images, 0, args.length);");
        expectedContent.add("        this.frames = args.length;");
        expectedContent.add("    }");
        expectedContent.add("");
        expectedContent.add("    //calling this method makes the animation run in backend");
        expectedContent.add("    public void runAnimation() {");
        expectedContent.add("        index++;");
        expectedContent.add("        if (index > speed) {");
        expectedContent.add("            index = 0;");
        expectedContent.add("            nextFrame();");
        expectedContent.add("        }");
        expectedContent.add("    }");
        expectedContent.add("");
        expectedContent.add("    //this method changes the frame");
        expectedContent.add("    public void nextFrame() {");
        expectedContent.add("        for (int i = 0; i < frames; i++) {");
        expectedContent.add("            if (count == i) {");
        expectedContent.add("                currentImg = images[i];");
        expectedContent.add("            }");
        expectedContent.add("        }");
        expectedContent.add("        count++;");
        expectedContent.add("        if (count > frames) {");
        expectedContent.add("            count = 0;");
        expectedContent.add("        }");
        expectedContent.add("    }");
        expectedContent.add("");
        expectedContent.add("    public void drawAnimation(Graphics2D g, int x, int y, int scalex, int scaley) {");
        expectedContent.add("        g.drawImage(currentImg, x, y, scalex, scaley, null);");
        expectedContent.add("    }");
        expectedContent.add("");
        expectedContent.add("    public void drawAnimation(Graphics2D g, int x, int y) {");
        expectedContent.add("        g.drawImage(currentImg, x, y, null);");
        expectedContent.add("    }");
        expectedContent.add("}");

        String filepath = "https://raw.githubusercontent.com/tachyontec/Troys_Quest/dev/src/main/java/main/game/Animation.java";
        String locationType = "web";
        SourceFileReaderFacade facade = new SourceFileReaderFacade();

        // Act
        List<String> actualContent = facade.readFileIntoList(filepath, locationType);

        // Assert
        Assert.assertEquals(expectedContent, actualContent);
    }

    @Test
    public void testReadFileIntoString_LocalFile_Success() throws IOException {
        // Arrange
        String expectedContent = "public class Class1 {\n" +
                "\t\t// simple comment\n" +
                "// simple comment 2\n" +
                "\n" +
                " /* long comment 1 */\n" +
                " \n" +
                " /* \n" +
                " * \n" +
                " * long comment 2 \n" +
                " */\n" +
                "\n" +
                "\tpublic void foo() {}\n" +
                "\n" +
                "\tString foo2() {\n" +
                "\t\tint x = Math.pow(2,2);\n" +
                "\t}\n" +
                "}\n" +
                "\n" +
                "class Class2{\n" +
                "\n" +
                "\tstatic void foo3(){\n" +
                "\n" +
                "} \n" +
                "\n" +
                "}\n" +
                "\n" +
                "class Class3 {\n" +
                "\t/***\n" +
                "\t*\n" +
                "\t* Javadoc comment\n" +
                "\t*/\n" +
                "}\n";

        String filepath = "src/test/resources/TestClass.java";
        String locationType = "local";
        SourceFileReaderFacade facade = new SourceFileReaderFacade();

        // Act
        String actualContent = facade.readFileIntoString(filepath, locationType);

        // Assert
        Assert.assertEquals(expectedContent, actualContent);
    }

    @Test
    public void testReadFileIntoString_WebFile_Success() throws IOException {
        // Arrange
        String expectedContent = "package main.game;\n" +
                "\n" +
                "import java.awt.*;\n" +
                "import java.awt.image.BufferedImage;\n" +
                "\n" +
                "//this class draws the animation in the screen\n" +
                "public class Animation {\n" +
                "    public int frames; // how many photos we have to change for the animation to be done\n" +
                "    public int speed; //the speed that we change the photos\n" +
                "    public int index = 0;\n" +
                "    public int count = 0;\n" +
                "    public BufferedImage[] images; //the images that are needed for the animation\n" +
                "    public BufferedImage currentImg;//used to refer to the current image while drawing the animation\n" +
                "\n" +
                "    //constructor that gets a list or a table of BufferedImage\n" +
                "    //its initializes the images table\n" +
                "    public Animation(int speed, BufferedImage... args) {\n" +
                "        images = new BufferedImage[args.length];\n" +
                "        //The speed will depend on how many images we have\n" +
                "        this.speed = 60 / args.length - speed; // bigger speed -> slower animation and vice versa\n" +
                "        //Copy args array into images:\n" +
                "        System.arraycopy(args, 0, images, 0, args.length);\n" +
                "        this.frames = args.length;\n" +
                "    }\n" +
                "\n" +
                "    //calling this method makes the animation run in backend\n" +
                "    public void runAnimation() {\n" +
                "        index++;\n" +
                "        if (index > speed) {\n" +
                "            index = 0;\n" +
                "            nextFrame();\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    //this method changes the frame\n" +
                "    public void nextFrame() {\n" +
                "        for (int i = 0; i < frames; i++) {\n" +
                "            if (count == i) {\n" +
                "                currentImg = images[i];\n" +
                "            }\n" +
                "        }\n" +
                "        count++;\n" +
                "        if (count > frames) {\n" +
                "            count = 0;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    public void drawAnimation(Graphics2D g, int x, int y, int scalex, int scaley) {\n" +
                "        g.drawImage(currentImg, x, y, scalex, scaley, null);\n" +
                "    }\n" +
                "\n" +
                "    public void drawAnimation(Graphics2D g, int x, int y) {\n" +
                "        g.drawImage(currentImg, x, y, null);\n" +
                "    }\n" +
                "}\n";

        String filepath = "https://raw.githubusercontent.com/tachyontec/Troys_Quest/dev/src/main/java/main/game/Animation.java";
        String locationType = "web";
        SourceFileReaderFacade facade = new SourceFileReaderFacade();

        // Act
        String actualContent = facade.readFileIntoString(filepath, locationType);

        // Assert
        Assert.assertEquals(expectedContent, actualContent);
    }
}
