package presentation.navigation;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
import java.util.Map.Entry;

public class Navigator {
    private Map<String, Class<Frame>> frames = new HashMap<>();
    private Stack<Frame> frameStack = new Stack<>();

    public void init(String initialFrame) {
        try {
            Optional<Entry<String, Class<Frame>>> entry = frames.entrySet().stream().filter(f -> f.getKey() == initialFrame).findFirst();
            
            String key = entry.get().getKey();
            Class<Frame> frameClass = entry.get().getValue();
            
            Frame frame = frameClass.getConstructor(String.class, Navigator.class).newInstance(key, this);
            frameStack.clear();
            frameStack.push(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Frame> void addFrame(String key, Class<T> frame) {
        this.frames.put(key, (Class<Frame>) frame);
    }

    public void navigate(String key) {
        Optional<Entry<String, Class<Frame>>> entry = frames.entrySet().stream().filter(f -> f.getKey() == key).findFirst();

        if(!entry.isPresent()){
            System.out.println("Error: Frame \"" + key +"\" não encontrado");
        } else {
            try {
                Class<Frame> frameClass = entry.get().getValue();

                Frame frameInstance = frameClass.getConstructor(String.class, Navigator.class).newInstance(key, this);
                
                frameStack.push(frameInstance);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void navigate(String key, HashMap<String, Object> params) {
        Optional<Entry<String, Class<Frame>>> entry = frames.entrySet().stream().filter(f -> f.getKey() == key).findFirst();

        if(!entry.isPresent()){
            System.out.println("Error: Frame \"" + key +"\" não encontrado");
        } else {
            try {
                Class<Frame> frameClass = entry.get().getValue();

                Frame frameInstance = frameClass
                    .getConstructor(String.class, Navigator.class, HashMap.class)
                    .newInstance(key, this, params);
    
                frameStack.push(frameInstance);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void goBack() {
        frameStack.pop();
    }
    
    public boolean isEmpty() {
        return this.frameStack.empty();
    }

    @SuppressWarnings("resource")
    public void renderCurrentFrame() {
        try {
            clearFrame();
            Frame frame = frameStack.peek();
            frame.render();
        } catch(Exception e) {
            clearFrame();
            System.out.println("\n\n" + e.getMessage());
            System.out.println("Pressione Enter para continuar...");
            
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
    }


    private void clearFrame(){
        try{
            String operatingSystem = System.getProperty("os.name");
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
    
                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
