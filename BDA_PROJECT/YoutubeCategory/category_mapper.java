package bda_project;


import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class category_mapper extends Mapper<LongWritable,Text,Text,IntWritable>{
		private Text category = new Text();
		private final static IntWritable occurance = new IntWritable(1);
		public void map(LongWritable key, Text value,
				Context context) throws IOException,InterruptedException {
			
			String record = value.toString();
			String str[] = record.split(",");
			if(str.length>5){
				category.set(str[3]);
			}
			context.write(category, occurance);
		}
	}

