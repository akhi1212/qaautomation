package org.autodatacorp.vindescription.common;

import java.io.File;

public class SchemaFileAccess {


    public SchemaFileAccess(){ }

    public File getSchemaFile(String schemaFilePath) {
        return new File(schemaFilePath);
    }

}
