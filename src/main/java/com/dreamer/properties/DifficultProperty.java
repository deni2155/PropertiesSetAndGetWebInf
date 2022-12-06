package com.dreamer.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "difficultProperty")
@SessionScoped
public class DifficultProperty implements Serializable {
    
    private String currentDir;
    private String name;
    private String property;

    public DifficultProperty() {}
    
    public String getName() {
        return name;
    }
    
    public void setName() throws FileNotFoundException, IOException {
        //this.currentDir = DifficultProperty.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        FileInputStream fis=new FileInputStream("./../webapps/Properties-1.0-SNAPSHOT/WEB-INF/my.properties");
        Properties prop=new Properties();
        prop.load(fis);
        name=prop.getProperty("USERNAME");
        fis.close();
    }

    
    public void setProperty() throws FileNotFoundException, IOException{
        Properties prop=new Properties();
        prop.setProperty("one","1");
        FileOutputStream out=new FileOutputStream("./../webapps/Properties-1.0-SNAPSHOT/WEB-INF/my.properties");
        prop.store(out,"mycomment");
    }
    public String getProperty() throws FileNotFoundException, IOException{
        FileInputStream fis=new FileInputStream("./../webapps/Properties-1.0-SNAPSHOT/WEB-INF/my.properties");
        Properties prop=new Properties();
        prop.load(fis);
        property=prop.getProperty("one");
        fis.close();
        return property;
        
        /*
        FileInputStream file=new FileInputStream(ManagedBean.class.getProtectionDomain().getCodeSource().getLocation().getPath()+"/../my.properties");
        Properties prop=new Properties();
        prop.load(file);
        name=prop.getProperty("name");
        file.close();
        */
    }
    
    //основная процедура для работы с файлом свойств, которая выступает в качестве постконструктора
    /*
    @PostConstruct()
    private void getProperties(){
        InputStream inputStream= null;
        try{
            if(path!=null){
                inputStream=this.getClass().getResourceAsStream(path);//подключаю пеерменную path к считывателю
                property.load(inputStream);
                name2=property.getProperty("USERNAME");
            }
        }
        catch(IOException ex){
            //System.out.print(ex.toString());
        }
        finally{
            if(inputStream!=null){
                try{
                    inputStream.close();
                }
                catch(IOException ex){
                    //System.out.print(ex.toString());
                }
            }
        }
    }   */
}
