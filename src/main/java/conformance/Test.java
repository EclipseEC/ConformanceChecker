package conformance;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.deckfour.xes.extension.std.XConceptExtension;
import org.deckfour.xes.extension.std.XLifecycleExtension;
import org.deckfour.xes.extension.std.XTimeExtension;
import org.deckfour.xes.model.XEvent;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;
import org.processmining.models.connections.GraphLayoutConnection;
import org.processmining.models.graphbased.directed.petrinet.PetrinetGraph;
import org.processmining.models.graphbased.directed.petrinet.elements.Place;
import org.processmining.models.graphbased.directed.petrinet.elements.Transition;
import org.processmining.models.graphbased.directed.petrinet.impl.PetrinetFactory;
import org.processmining.models.semantics.petrinet.Marking;
import org.processmining.plugins.pnml.Pnml;

import parser.PnmlImportUtils;
import parser.XLogReader;

public class Test {
    private static final String PNML = "src/main/resources/test.pnml";
    private static final String XES = "src/main/resources/test.xes";

    private static PetriNet petriNet;
    private static EventLog eventLog;

    public static void main(String[] args) {
        try {
            petriNet = getPetriNet();
            eventLog = parseEventLog();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PetriNet getPetriNet() throws Exception {
        PetriNet petriNet = new PetriNet();
        PnmlImportUtils ut = new PnmlImportUtils();
        File f = new File(PNML);
        InputStream input = new FileInputStream(f);
        Pnml pnml = ut.importPnmlFromStream(input, f.getName(), f.length());
        PetrinetGraph net = PetrinetFactory
                .newInhibitorNet(pnml.getLabel() + " (imported from " + f.getName() + ")");
        Marking marking = new Marking();
        pnml.convertToNet(net, marking, new GraphLayoutConnection(net));
        //Parsing places
        for (Place place : net.getPlaces()) {
            NPlace newPlace = new NPlace();
            newPlace.setLabel(place.getLabel());
            petriNet.getPlaces().add(newPlace);
        }
        //Parsing transitions
        for (Transition transition : net.getTransitions()) {
            NTransition newTransition = new NTransition();
            newTransition.setLabel(transition.getLabel());
            for (Transition transitionPre : transition.getVisiblePredecessors()) {
                NTransition newTransitionPre = new NTransition();
                newTransitionPre.setLabel(transitionPre.getLabel());
                newTransition.getVisiblePredecessors().add(newTransitionPre);
            }
            for (Transition transitionPost : transition.getVisibleSuccessors()) {
                NTransition newTransitionPost = new NTransition();
                newTransitionPost.setLabel(transitionPost.getLabel());
                newTransition.getVisibleSuccessors().add(newTransitionPost);
            }
            petriNet.getTransitions().add(newTransition);
        }
        return petriNet;
    }

    private static EventLog parseEventLog() {
        try {
            EventLog eventLog = new EventLog();
            XLog log = XLogReader.openLog(XES);
            for (XTrace trace : log) {
                Case newCase = new Case();
                for (String key : trace.getAttributes().keySet()) {
                    newCase.getAttributes().put(key,
                            trace.getAttributes().get(key).toString());
                }
                newCase.setName(XConceptExtension.instance().extractName(trace));
                for (XEvent xevent : trace) {
                    Event event = new Event();
                    event.setName(XConceptExtension.instance().extractName(xevent));
                    event.setTimestamp(XTimeExtension.instance().extractTimestamp(xevent));
                    event.setType(XLifecycleExtension.instance().extractTransition(xevent));
                    for (String key : xevent.getAttributes().keySet()) {
                        event.getAttributes().put(key,
                                xevent.getAttributes().get(key).toString());
                    }
                    newCase.getEvents().add(event);
                }
                eventLog.getCases().add(newCase);
                return eventLog;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
