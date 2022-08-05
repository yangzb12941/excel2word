package com.wy.wordWriter;

import com.wy.elementHandler.TableElementHandler;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadExcels {

    private static volatile ReadExcels readExcels;

    public static ReadExcels getInstance(){
        if(readExcels == null){
            synchronized (TableElementHandler.class){
                if (readExcels == null) {
                    readExcels = new ReadExcels();
                }
            }
        }
        return readExcels;
    }

    /**
     *  <h1>获取指定文件夹下所有文件，不含文件夹</h1>
     * @param dirFilePath 文件夹路径
     * @return
     */
    public List<File> getAllFile(String dirFilePath){
        if(StringUtils.isBlank(dirFilePath))
            return null;
        return getAllFile(new File(dirFilePath));
    }

    /**
     *  <h1>获取指定文件夹下所有文件，不含文件夹</h1>
     * @param dirFile 文件夹
     * @return
     */
    private List<File> getAllFile(File dirFile){
        // 如果文件夹不存在或着不是文件夹，则返回 null
        List<File> files = new ArrayList<>();
        if(Objects.isNull(dirFile) || !dirFile.exists())
            return null;
        //若是选择的是单个文件，则直接返回单个文件列表
        if(dirFile.isFile()){
            files.add(dirFile);
            return files;
        }
        //若是选择的文件夹，则获取文件夹下的文件
        File[] childrenFiles =  dirFile.listFiles();
        if(Objects.isNull(childrenFiles) || childrenFiles.length == 0)
            return null;
        for(File childFile : childrenFiles) {
            // 如果时文件，直接添加到结果集合
            if(childFile.isFile()) {
                files.add(childFile);
            }else {
                // 如果是文件夹，则将其内部文件添加进结果集合
                List<File> cFiles =  getAllFile(childFile);
                if(Objects.isNull(cFiles) || cFiles.isEmpty()) continue;
                files.addAll(cFiles);
            }

        }
        return files;
    }
}
