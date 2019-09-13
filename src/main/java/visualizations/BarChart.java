package visualizations;


import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.VerticalBarPlot;

/**
 * Class that plots basic Bar charts.
 */
public class BarChart {

    /**
     * Plot basic bar chart given
     * chart title, data set in Table format,
     * x-axis name, y-axis name.
     */
    public static void plotBar(
            String chartTitle, Table table, String groupColName, String numberColName) {

        Plot.show(VerticalBarPlot.create(chartTitle, table, groupColName, numberColName));
    }

}
