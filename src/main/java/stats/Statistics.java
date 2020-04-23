package stats;


import datasets.VectorDouble;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import utils.ListUtils;

import java.util.List;

/**
 * Simple class that holds some basic statistics usually
 * required by an application when working on a dataset
 */
public class Statistics {

    /**
     * Enumeration of the various metrics
     */
    public enum Metrics{
        MEAN,
        MEADIAN,
        VAR,
        MAX,
        MIN,
        SKEWNESS,
        KURTOSIS,
        INVALID_METRIC
    }

    public double mean=0.0;
    public double variance=0.0;
    public double median=0.0;
    public double max=0.0;
    public double min=0.0;
    public double skewness=0.0;
    public double kurtosis=0.0;
	public boolean isValid =false;

    /**
     * Prints the computed Statistics
     */
	public final void printInfo(){
	    System.out.println(this.toString());
    }

    /**
     * Convert the computed metrics aggregated into a string
     * @return String
     */
    @Override
    public final String toString(){

	    String str = new String();
	    str = "Mean:  "+new Double(mean).toString()+"\n";
        str += "Variance:  "+new Double(variance).toString()+"\n";
        str += "Median:  "+new Double(median).toString()+"\n";
        str += "Max:  "+new Double(max).toString()+"\n";
        str += "Min:  "+new Double(min).toString()+"\n";
        str += "Skewness:  "+new Double(skewness).toString()+"\n";
        str += "Kurtosis:  "+new Double(kurtosis).toString()+"\n";
        str += "Valid:     "+new Boolean(isValid).toString()+"\n";
	    return str;
    }

    /**
     * Calculate the given metric from the given data
     * @param data The data to calculate the metric
     * @param metric The metric to calculate
     * @return double
     */
    public static double calculate(double[] data, Metrics metric){

        if(data.length == 0){
            throw new IllegalArgumentException("The data set given is empty");
        }

        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(data);

        switch (metric){
            case MEAN:
                return descriptiveStatistics.getMean();
            case MEADIAN:
                return descriptiveStatistics.getPercentile(50.0);
            case VAR:
                return descriptiveStatistics.getVariance();
            case MAX:
                return descriptiveStatistics.getMax();
            case MIN:
                return descriptiveStatistics.getMin();
            case KURTOSIS:
                return descriptiveStatistics.getKurtosis();
            case SKEWNESS:
                return descriptiveStatistics.getSkewness();
            default:
                throw new IllegalArgumentException("Invalid Metric type");
        }
    }

    /**
     * Calculate the given metric from the given data
     * @param data The data to calculate the metric
     * @param metric The metric to calculate
     * @return double
     */
    public static double calculate(List<Double> data, Metrics metric){

        if(data.isEmpty()){
            throw new IllegalArgumentException("The data set given is empty");
        }

        return Statistics.calculate(ListUtils.toDoubleArray(data), metric);
    }

    /**
     * Calculate the given metric from the given data
     * @param data The data to calculate the metric
     * @param metric The metric to calculate
     * @return double
     */
    public static double calculate(VectorDouble data, Metrics metric){

        if(data.empty()){
            throw new IllegalArgumentException("The data set given is empty");
        }

        return Statistics.calculate(data.getRawData(), metric);
    }

    /**
     *
     * @param data The data to calculate the statistics
     * @return Statistics instance
     */
    public static Statistics calculate(double[] data){


        if(data.length == 0){
            throw new IllegalArgumentException("The data set given is empty");
        }

        Statistics statistics = new Statistics();
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(data);
        statistics.mean = descriptiveStatistics.getMean();
        statistics.median = descriptiveStatistics.getPercentile(50.0);
        statistics.variance = descriptiveStatistics.getVariance();
        statistics.max = descriptiveStatistics.getMax();
        statistics.min = descriptiveStatistics.getMin();
        statistics.kurtosis = descriptiveStatistics.getKurtosis();
        statistics.skewness = descriptiveStatistics.getSkewness();
        statistics.isValid = true;
        return  statistics;
    }

    /**
     *
     * @param data The data to calculate the statistics
     * @return Statistics instance
     */
    public static Statistics calculate(List<Double> data){

	    if(data.isEmpty()){
	        throw new IllegalArgumentException("The data set given is empty");
        }

        return Statistics.calculate(ListUtils.toDoubleArray(data));
    }

    /**
     *
     * @param data The data to calculate the statistics
     * @return Statistics instance
     */
    public static Statistics calculate(VectorDouble data){

        if(data.empty()){
            throw new IllegalArgumentException("The data set given is empty");
        }

        return Statistics.calculate(data.getRawData());
    }
}
