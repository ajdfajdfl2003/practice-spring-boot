package idv.angus.springboot.controller;

import idv.angus.springboot.service.ProxyManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/proxy")
public class ProxyManagerController {
    private final ProxyManager manager;

    public ProxyManagerController(ProxyManager manager) {
        this.manager = manager;
    }

    @GetMapping("/A/{key}")
    public String getA(@PathVariable String key) {
        return manager.getA(key);
    }

    @GetMapping("/{key}")
    public String get(@PathVariable String key) {
        return manager.get(key);
    }
}
