package bda_project_youtubeuploader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import java.io.IOException;
public class uploader_driver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		//JobConf conf = new JobConf(WordCount.class);
		Configuration conf1= new Configuration();
		
		
		//conf.setJobName("mywc");
		@SuppressWarnings("deprecation")
		Job job = new Job(conf1,"myyoutube");
		
		job.setJarByClass(uploader_driver.class);
		job.setMapperClass(uploader_mapper.class);
		job.setReducerClass(uploader_reducer.class);
		
		//conf.setMapperClass(Map.class);
		//conf.setReducerClass(Reduce.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
	
		
		//job.setInputFormatClass(TextInputFormat.class);
		//job.setOutputFormatClass(TextOutputFormat.class);

		@SuppressWarnings("unused")
		Path outputPath = new Path(args[1]);
			
	        //Configuring the input/output path from the filesystem into the job
	        
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
			
			//deleting the output path automatically from hdfs so that we don't have delete it explicitly
			
		//outputPath.getFileSystem(conf).delete(outputPath);
			
			//exiting the job only if the flag value becomes false
			
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}



}


