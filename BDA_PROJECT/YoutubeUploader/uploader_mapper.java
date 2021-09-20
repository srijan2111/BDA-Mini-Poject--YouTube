package bda_project_youtubeuploader;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class uploader_mapper extends Mapper<LongWritable,Text,Text,IntWritable>{

		private Text uploader = new Text();
		private final static IntWritable occurance = new IntWritable(1);
		public void map(LongWritable key, Text value,
				Context context) throws IOException,InterruptedException {
			
			String record = value.toString();
			String str[] = record.split(",");
			if(str.length>=7){
				uploader.set(str[7]);
			}
			context.write(uploader, occurance);
		}
}


