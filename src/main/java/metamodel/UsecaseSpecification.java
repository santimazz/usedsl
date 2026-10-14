package metamodel;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashSet;

public class UsecaseSpecification {

    public Map<Integer, Usecase> usecases;

    public UsecaseSpecification() {
        this.usecases = new HashMap<>();
    }

    public UsecaseSpecification(List<Usecase> usecases) {
        this.usecases = new HashMap<>();
        for (Usecase ucase : usecases) {
            addUsecase(ucase);
        }
    }
    /**
     * if throwing an IllegalArgumentException it's duplicate IDs
     */
    public void addUsecase(Usecase usecase) throws IllegalArgumentException {
        if (usecases.get(usecase.getId()) == null) {
            this.usecases.put(usecase.getId(), usecase);
        } else throw new IllegalArgumentException("Usecase ID " + usecase.getId()  + " duplicated!", null);
    }

    public Usecase getUsecase(Integer id) {
        return usecases.get(id);
    }

    /** 
     * @return an ArrayList with all usecases.
     */
    public ArrayList<Usecase> getAllUsecases() {
        return new ArrayList<Usecase>(usecases.values());
    }

    /**
     * Executes each step defined within the specified usecase flow/slice, after setting
     * each precondition
     * 
     * If no flow is specified, runs each flow.
     * Flow statements of type ""
     * 
     * @param usecase The use case to run.
     * @param flow The flow within the use case to run.
     * @throws InvalidFlowException Description of exception.
     */
    public void runUsecase(Usecase usecase, String flow) {
        
    }
}
