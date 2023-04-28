# Occidental Mindoro State College Online student information and management system

![Cover](image\Cover.jpg)

--------

The Occidental Mindoro State College Online student information and management system is a web-based tool designed to provide students, faculty, and staff with real-time access to academic and personal information. The system allows students to view and update their enrollment data, personal information, education background, employment records, and medical information, as well as track their progress towards meeting degree requirements. In addition, the system provides access to online tasks, modules, and attendance records. The system streamlines administrative tasks and facilitates communication between students, faculty, and staff, enhancing the academic experience for all stakeholders.

*Table of Contents*
===================
* [Title](#occidental-mindoro-state-college-online-student-information-and-management-system)
* [Table of Contents](#table-of-contents)
  * Description
* [Introduction](#introduction)


# introduction
The Occidental Mindoro State College Online student information and management system is an innovative tool designed to enhance the academic experience of students, faculty, and staff. As educational institutions become increasingly reliant on technology, it is important to develop systems that can effectively manage student information, streamline administrative tasks, and provide real-time access to data. In this research paper, we aim to evaluate the effectiveness of the Occidental Mindoro State College Online student information and management system, and examine its impact on various stakeholders.

We will begin by providing a comprehensive overview of the system, including its features and functionalities. We will also examine the existing literature on online student information and management systems, and identify best practices and key success factors. We will then describe our research methodology, which will involve a survey of students, faculty, and staff to gather their feedback and opinions on the system. We will also collect data on system usage and performance, and conduct a comparative analysis of the system's performance against established benchmarks.

The results of this study will provide valuable insights into the effectiveness of the Occidental Mindoro State College Online student information and management system, and its impact on various stakeholders. We hope that this research will contribute to the ongoing dialogue on the role of technology in education, and inform the development of future systems and practices in this field.

# Obecjecives
- To provide students with easy access to their academic and personal information, such as enrollment data, education background, and contact information.
- To streamline administrative tasks and processes, such as enrollment management, record keeping, and grading.
- To enhance communication and collaboration between students, faculty, and staff through online tasks, modules, and messaging.
- To improve student engagement and performance through real-time tracking of attendance records, online task submissions, and module completion.
- To provide instructors with a comprehensive tool for managing course content, including readings, lectures, assignments, and exams.
- To improve the accuracy and security of student data by providing a centralized and secure database.
- To reduce paper-based processes and promote sustainability through online record keeping and communication.
- To continuously evaluate and improve the system based on feedback from students, faculty, and staff, and industry best practices.

# Features
### **Administrative**
### **Instructor**
### **Student**
- **Enrollment Data**: Students can view their enrollment status, courses enrolled, and any fees or charges.
- **Personal Information**: Students can view and update their personal information, such as name, date of birth, gender, and contact information.
- **Addresses & Contacts**: Students can view and update their mailing address and contact details.
- **Education Background**: Students can view their educational history, including degrees earned and transcripts.
- **Medical Info**: Students can view any medical information that has been submitted, such as allergies, disabilities, and emergency contacts.
- **Employment Records**: Students can view any employment records, such as work-study or on-campus employment.
- **Online Tasks**: Students can view any online tasks assigned by their instructors, such as assignments, quizzes, or discussion forums.
- **Modules**: Students can view the modules for each course they are enrolled in, including readings, lectures, and assignments.
- **Absences**: Students can view their attendance records for each course, including absences and tardiness.
- **Curriculum Evaluation**: Students can view their progress towards meeting degree requirements, including required courses and electives.
### **Parent**
### **Admissions**

# **Building**
You need to make sure that you have [JDK 19](https://www.oracle.com/java/technologies/javase/jdk19-archive-downloads.html) or [JDK 20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html) Else it will not work

## Members & Roles
--------

- Nicholas John C. Abeleda (Head Programmer)
- Chris La Rosa (Sub-Programmer)
- Treasee May Estefanio (Graphics Designer)
- Mark Anthony Rosete (Graphics Designer)
- Edriel Begornia (Researcher) 
- Curt David Tibayan Gamil (Researcher)
- Brylle Darren Ramos (Researcher)
- Thaddeus Embanecido Binasag (Researcher) 
- James Dwight Jimenez Aban (Researcher) 
- Jaztin Gaytano (Researcher)
- Justine Noble Costales (Researcher) 
- Mark Del Mundo (Paper Works)
- Mayrine Balanon Francisco Balan (Paper Works) 
- Devon Pajaro (Paper Works)
- RaChelle Bade Tan (Paper Works)
- Tiegie Salazar Estabillo (Paper Works)
- Rj Bangsoy Bical (Paper Works)

- Vhalerey Jaravata (Paper Works)
- Wendy Alerta (Paper Works)
## File data structure

--------

```css
Final_Project/
├── Data/
│   ├── MidtermExam/
│   │   ├── Answers.txt
│   │   ├── Answers1.txt
│   │   ├── Choice.txt
│   │   ├── Choice1.txt 
│   │   └── Questions.txt
│   ├── Accounts.txt
│   └── InsAccounts.txt
│   
├── image/
│   ├── Cover.jpg
│   └── Icon.png
│
├── Main/
│   ├── Activities/
│   ├── Exam/
│   │   ├── ExamMenu.java
│   │   └── JavaExam/
│   ├── Quizes/
│   ├── AdminLoginForm.java
│   ├── InstructorLoginForm.java
│   ├── MainMenu.java
│   ├── ParentLoginForm.java
│   ├── StudentLoginForm.java
│   └── StudentRegisterForm.java
│
├── Sub/
│   ├──Table/
│   │   ├── ClassAbs.java
│   │   ├── CurriculumEvaluation.java
│   │   ├── EnrolledSub.java
│   │   ├── Modules.java 
│   │   └── OnlineTask.java
│   ├── Loading.java
│   ├── Paint.java
│   ├── Questions.java
│   └── SciCal.java
│    
├── .env
├── Main.java
└── README.md

```

## Sequence Diagram

----------                    
              
```seq
Main.java ->> Loading.java: Open
    Loading.java ->> MainMenu.java: Open
    MainMenu.java ->> AdminLoginForm.java: Click
    AdminLoginForm.java ->> Data/Accounts.txt: Access
    AdminLoginForm.java ->> Data/InsAccounts.txt: Access
    AdminLoginForm.java ->> image/Cover.jpg: Access
    AdminLoginForm.java ->> image/Icon.png: Access
    MainMenu.java ->> InstructorLoginForm.java: Click
    InstructorLoginForm.java ->> Data/Accounts.txt: Access
    InstructorLoginForm.java ->> Data/InsAccounts.txt: Access
    InstructorLoginForm.java ->> image/Cover.jpg: Access
    InstructorLoginForm.java ->> image/Icon.png: Access
    MainMenu.java ->> ParentLoginForm.java: Click
    ParentLoginForm.java ->> Data/Accounts.txt: Access
    ParentLoginForm.java ->> Data/InsAccounts.txt: Access
    ParentLoginForm.java ->> image/Cover.jpg: Access
    ParentLoginForm.java ->> image/Icon.png: Access
    MainMenu.java ->> StudentLoginForm.java: Click
    StudentLoginForm.java ->> Data/Accounts.txt: Access
    StudentLoginForm.java ->> Data/InsAccounts.txt: Access
    StudentLoginForm.java ->> image/Cover.jpg: Access
    StudentLoginForm.java ->> image/Icon.png: Access
    StudentLoginForm.java ->> Table/ClassAbs.java: Access
```

Bower install :

```bash
bower install editor.md
```

#### Usages

##### Create a Markdown editor

```html
<link rel="stylesheet" href="editor.md/css/editormd.min.css" />
<div id="editor">
    <!-- Tips: Editor.md can auto append a `<textarea>` tag -->
    <textarea style="display:none;">### Hello Editor.md !</textarea>
</div>
<script src="jquery.min.js"></script>
<script src="editor.md/editormd.min.js"></script>
<script type="text/javascript">
    $(function() {
        var editor = editormd("editor", {
            // width: "100%",
            // height: "100%",
            // markdown: "xxxx",     // dynamic set Markdown text
            path : "editor.md/lib/"  // Autoload modules mode, codemirror, marked... dependents libs path
        });
    });
</script>
```

If you using modular script loader:

- [Using Require.js](https://github.com/pandao/editor.md/tree/master/examples/use-requirejs.html)
- [Using Sea.js](https://github.com/pandao/editor.md/tree/master/examples/use-seajs.html)

##### Markdown to HTML

```html
<link rel="stylesheet" href="editormd/css/editormd.preview.css" />
<div id="test-markdown-view">
    <!-- Server-side output Markdown text -->
    <textarea style="display:none;">### Hello world!</textarea>             
</div>
<script src="jquery.min.js"></script>
<script src="editormd/editormd.js"></script>
<script src="editormd/lib/marked.min.js"></script>
<script src="editormd/lib/prettify.min.js"></script>
<script type="text/javascript">
    $(function() {
	    var testView = editormd.markdownToHTML("test-markdown-view", {
            // markdown : "[TOC]\n### Hello world!\n## Heading 2", // Also, you can dynamic set Markdown text
            // htmlDecode : true,  // Enable / disable HTML tag encode.
            // htmlDecode : "style,script,iframe",  // Note: If enabled, you should filter some dangerous HTML tags for website security.
        });
    });
</script>    
```

> See the full example: [http://editor.md.ipandao.com/examples/html-preview-markdown-to-html.html](http://editor.md.ipandao.com/examples/html-preview-markdown-to-html.html)

##### HTML to Markdown?

Sorry, Editor.md not support HTML to Markdown parsing, Maybe In the future.

#### Examples

[https://pandao.github.io/editor.md/examples/index.html](https://pandao.github.io/editor.md/examples/index.html)

#### Options

Editor.md options and default values:

```javascript
{
    mode                 : "gfm",          // gfm or markdown
    name                 : "",             // Form element name for post
    value                : "",             // value for CodeMirror, if mode not gfm/markdown
    theme                : "",             // Editor.md self themes, before v1.5.0 is CodeMirror theme, default empty
    editorTheme          : "default",      // Editor area, this is CodeMirror theme at v1.5.0
    previewTheme         : "",             // Preview area theme, default empty
    markdown             : "",             // Markdown source code
    appendMarkdown       : "",             // if in init textarea value not empty, append markdown to textarea
    width                : "100%",
    height               : "100%",
    path                 : "./lib/",       // Dependents module file directory
    pluginPath           : "",             // If this empty, default use settings.path + "../plugins/"
    delay                : 300,            // Delay parse markdown to html, Uint : ms
    autoLoadModules      : true,           // Automatic load dependent module files
    watch                : true,
    placeholder          : "Enjoy Markdown! coding now...",
    gotoLine             : true,           // Enable / disable goto a line
    codeFold             : false,
    autoHeight           : false,
    autoFocus            : true,           // Enable / disable auto focus editor left input area
    autoCloseTags        : true,
    searchReplace        : true,           // Enable / disable (CodeMirror) search and replace function
    syncScrolling        : true,           // options: true | false | "single", default true
    readOnly             : false,          // Enable / disable readonly mode
    tabSize              : 4,
    indentUnit           : 4,
    lineNumbers          : true,           // Display editor line numbers
    lineWrapping         : true,
    autoCloseBrackets    : true,
    showTrailingSpace    : true,
    matchBrackets        : true,
    indentWithTabs       : true,
    styleSelectedText    : true,
    matchWordHighlight   : true,           // options: true, false, "onselected"
    styleActiveLine      : true,           // Highlight the current line
    dialogLockScreen     : true,
    dialogShowMask       : true,
    dialogDraggable      : true,
    dialogMaskBgColor    : "#fff",
    dialogMaskOpacity    : 0.1,
    fontSize             : "13px",
    saveHTMLToTextarea   : false,          // If enable, Editor will create a <textarea name="{editor-id}-html-code"> tag save HTML code for form post to server-side.
    disabledKeyMaps      : [],
    
    onload               : function() {},
    onresize             : function() {},
    onchange             : function() {},
    onwatch              : null,
    onunwatch            : null,
    onpreviewing         : function() {},
    onpreviewed          : function() {},
    onfullscreen         : function() {},
    onfullscreenExit     : function() {},
    onscroll             : function() {},
    onpreviewscroll      : function() {},
    
    imageUpload          : false,          // Enable/disable upload
    imageFormats         : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
    imageUploadURL       : "",             // Upload url
    crossDomainUpload    : false,          // Enable/disable Cross-domain upload
    uploadCallbackURL    : "",             // Cross-domain upload callback url

    toc                  : true,           // Table of contents
    tocm                 : false,          // Using [TOCM], auto create ToC dropdown menu
    tocTitle             : "",             // for ToC dropdown menu button
    tocDropdown          : false,          // Enable/disable Table Of Contents dropdown menu
    tocContainer         : "",             // Custom Table Of Contents Container Selector
    tocStartLevel        : 1,              // Said from H1 to create ToC
    htmlDecode           : false,          // Open the HTML tag identification 
    pageBreak            : true,           // Enable parse page break [========]
    atLink               : true,           // for @link
    emailLink            : true,           // for email address auto link
    taskList             : false,          // Enable Github Flavored Markdown task lists
    emoji                : false,          // :emoji: , Support Github emoji, Twitter Emoji (Twemoji);
                                           // Support FontAwesome icon emoji :fa-xxx: > Using fontAwesome icon web fonts;
                                           // Support Editor.md logo icon emoji :editormd-logo: :editormd-logo-1x: > 1~8x;
    tex                  : false,          // TeX(LaTeX), based on KaTeX
    flowChart            : false,          // flowChart.js only support IE9+
    sequenceDiagram      : false,          // sequenceDiagram.js only support IE9+
    previewCodeHighlight : true,           // Enable / disable code highlight of editor preview area

    toolbar              : true,           // show or hide toolbar
    toolbarAutoFixed     : true,           // on window scroll auto fixed position
    toolbarIcons         : "full",         // Toolbar icons mode, options: full, simple, mini, See `editormd.toolbarModes` property.
    toolbarTitles        : {},
    toolbarHandlers      : {
        ucwords : function() {
            return editormd.toolbarHandlers.ucwords;
        },
        lowercase : function() {
            return editormd.toolbarHandlers.lowercase;
        }
    },
    toolbarCustomIcons   : {               // using html tag create toolbar icon, unused default <a> tag.
        lowercase        : "<a href=\"javascript:;\" title=\"Lowercase\" unselectable=\"on\"><i class=\"fa\" name=\"lowercase\" style=\"font-size:24px;margin-top: -10px;\">a</i></a>",
        "ucwords"        : "<a href=\"javascript:;\" title=\"ucwords\" unselectable=\"on\"><i class=\"fa\" name=\"ucwords\" style=\"font-size:20px;margin-top: -3px;\">Aa</i></a>"
    },
    toolbarIconTexts     : {},
    
    lang : {  // Language data, you can custom your language.
        name        : "zh-cn",
        description : "开源在线Markdown编辑器<br/>Open source online Markdown editor.",
        tocTitle    : "目录",
        toolbar     : {
            //...
        },
        button: {
            //...
        },
        dialog : {
            //...
        }
        //...
    }
}
```

#### Dependents

- [CodeMirror](http://codemirror.net/ "CodeMirror")
- [marked](https://github.com/markedjs/marked "marked")
- [jQuery](http://jquery.com/ "jQuery")
- [FontAwesome](http://fontawesome.io/ "FontAwesome")
- [github-markdown.css](https://github.com/sindresorhus/github-markdown-css "github-markdown.css")
- [KaTeX](http://khan.github.io/KaTeX/ "KaTeX")
- [prettify.js](http://code.google.com/p/google-code-prettify/ "prettify.js")
- [Rephael.js](http://raphaeljs.com/ "Rephael.js")
- [flowchart.js](http://adrai.github.io/flowchart.js/ "flowchart.js")
- [sequence-diagram.js](http://bramp.github.io/js-sequence-diagrams/ "sequence-diagram.js")
- [Prefixes.scss](https://github.com/pandao/prefixes.scss "Prefixes.scss")

#### Changes

[Change logs](https://github.com/pandao/editor.md/blob/master/CHANGE.md)

#### License

The MIT License.

Copyright (c) 2015-2019 Pandao
