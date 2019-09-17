package visualizations;

import datastructs.NumericSample;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.LinePlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.components.Line;
import tech.tablesaw.plotly.traces.ScatterTrace;

/**
 * Class that plots basic Line Charts.
 */

public class LineChart {

    public static class LineChartOptions {
        public String chartTitle;
        public double smoothing;
        public String xAxisName;
        public String yAxisName;

    }

    /**
     * Plots a line given the chart title,
     * data set in Table format,
     * and two numeric columns
     * created from a numeric sample
     * of the data set.
     */
    public static void plotLine(NumericSample x, NumericSample y, LineChartOptions options){

        DoubleColumn xcol = DoubleColumn.create(options.xAxisName, x.asArray());
        DoubleColumn ycol = DoubleColumn.create(options.yAxisName, y.asArray());
        Table table = Table.create(xcol, ycol);
        Plot.show(LinePlot.create(options.chartTitle, table, options.xAxisName, options.yAxisName));
    }

    /**
     * Plots a line given the chart title,
     * data set in Table format,
     * and two numeric columns.
     */
    public static void plotLine(LineChartOptions options, Table data) {

        Plot.show(LinePlot.create(options.chartTitle, data, options.xAxisName, options.yAxisName));

    }

    /**
     * Plots a line given the chart title,
     * data set in Table format,
     * two numeric columns and custom
     * smoothing.
     */

    public static void plotSmoothLine(LineChartOptions options, Table data) {

        Layout layout = Layout.builder().title(options.chartTitle).build();
        ScatterTrace trace = ScatterTrace
                .builder(data.numberColumn(options.xAxisName), data.numberColumn(options.yAxisName))
                .mode(ScatterTrace.Mode.LINE)
                .line(Line.builder().shape(Line.Shape.SPLINE).smoothing(options.smoothing).build())
                .build();
        Plot.show(new Figure(layout, trace));
    }

}
