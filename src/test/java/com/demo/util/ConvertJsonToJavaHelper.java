package com.demo.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import com.sun.codemodel.JCodeModel;

public class ConvertJsonToJavaHelper {
	
	public static void main(String[] args) throws IOException 
	{	
		File jsonfile = new File("src/test/resources/schema/jsonschema.json");
		String absolutePath = jsonfile.getAbsolutePath();
		URL inputJsonUrl = new URL("file:///" +absolutePath);
		
		File file = new File("src/test/java");
		convertJsonToJavaClass(inputJsonUrl, file, "com.demo.generatedjsonpojo", "RootPojo");
	}
	
	public static void convertJsonToJavaClass(URL inputJsonUrl, File outputJavaClassDirectory, String packageName, String javaClassName) throws IOException 
	{
		JCodeModel jcodeModel = new JCodeModel();

		GenerationConfig config = new DefaultGenerationConfig() {
			        @Override
			        public boolean isGenerateBuilders() {
			            return false;
			        }

			        @Override
			        public SourceType getSourceType() {
			            return SourceType.JSON;
			        }
			        
			        @Override
			        public boolean isIncludeToString() {
			            return false;
			        }

			        @Override
			        public boolean isIncludeHashcodeAndEquals() {
			            return false;
			        }
			        
			        @Override
			        public boolean isIncludeAdditionalProperties() {
			            return false;
			        }
			        
			        @Override
			        public boolean isIncludeGeneratedAnnotation() {
			            return false;
			        }
			        
			        @Override
			        public boolean isIncludeGetters() {
			            return false;
			        }
			        
			        @Override
			        public boolean isIncludeSetters() {
			            return false;
			        }
			    };

		SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
		mapper.generate(jcodeModel, javaClassName, packageName, inputJsonUrl);

		jcodeModel.build(outputJavaClassDirectory);
	}
}
