package conformance;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.processmining.models.connections.GraphLayoutConnection;
import org.processmining.models.graphbased.directed.petrinet.PetrinetGraph;
import org.processmining.models.graphbased.directed.petrinet.impl.PetrinetFactory;
import org.processmining.models.semantics.petrinet.Marking;
import org.processmining.plugins.pnml.Pnml;

import parser.PnmlImportUtils;

public class Test {
    private static final String PNML = "src/main/resources/test.pnml";
    private static final String XES = "src/main/resources/test.xes";

    public static void main(String[] args) {
        try {
            PetrinetGraph petriNet = getPetriNet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PetrinetGraph getPetriNet() throws Exception {
        PnmlImportUtils ut = new PnmlImportUtils();
        File f = new File(PNML);
        InputStream input = new FileInputStream(f);
        Pnml pnml = ut.importPnmlFromStream(input, f.getName(), f.length());
        PetrinetGraph net = PetrinetFactory
                .newInhibitorNet(pnml.getLabel() + " (imported from " + f.getName() + ")");
        Marking marking = new Marking();
        pnml.convertToNet(net, marking, new GraphLayoutConnection(net));
        return net;
    }
}
