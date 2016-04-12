package com.jiro.action;

import com.jiro.utility.FilesUtil;

import java.io.File;
import java.io.IOException;
 
import javax.servlet.ServletContext;
 
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;
 
public class UploadFileAction extends ActionSupport implements ServletContextAware{
 
    private static final long serialVersionUID = -4748500436762141116L;
 
    @Override
    public String execute(){
        try {
            FilesUtil.saveFile(getFile(), getFileFileName(), context.getRealPath("") + File.separator + filesPath);
            fileWithPath = "<img src=\"" + filesPath + "/" + getFileFileName() + "\" />";
            content += fileWithPath;
        } catch (IOException e) {
            e.printStackTrace();
            return INPUT;
        }
        return SUCCESS;
         
    }
         
    @Override
    public void validate() {
        if(file == null || fileContentType == null || filesPath == null) {
            System.out.println("NULL");
            addFieldError("errmsg", "Nothing to upload");
        }
    }



    private File file;
    private String fileContentType;
    private String fileFileName;
    private String filesPath;
    private ServletContext context;
    private String fileWithPath;
    private String title;
    private String content;
    private String postType;
    private long postId;
 
    public File getFile() {
        return file;
    }
 
    public void setFile(File file) {
        this.file = file;
    }
 
    public String getFileContentType() {
        return fileContentType;
    }
 
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
 
    public String getFileFileName() {
        return fileFileName;
    }
 
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
 
    public void setFilesPath(String filesPath) {
        this.filesPath = filesPath;
    }
     
    public String getFileWithPath() {
        return fileWithPath;
    }

    public void setFileWithPath(String fileWithPath) {
        this.fileWithPath = fileWithPath;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    @Override
    public void setServletContext(ServletContext ctx) {
        this.context=ctx;
    }
     
}