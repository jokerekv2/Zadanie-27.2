package pl.dm.cookbook.components;

import org.springframework.stereotype.Service;

@Service
public class ComponentsService {

    private final ComponentsRepository componentsRepository;

    public ComponentsService(ComponentsRepository componentsRepository) {
        this.componentsRepository = componentsRepository;
    }

    public void addComponent(Components components) {
        componentsRepository.save(components);
    }

    public Components findFirstByOrderByIdDesc() {
        return componentsRepository.findFirstByOrderByIdDesc();
    }
}
