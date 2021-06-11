package io.lenur.cloudx;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.amazonaws.util.EC2MetadataUtils;

@RestController
@RequestMapping("/instance")
public class InstanceController {
    @GetMapping("/metadata")
    public Metadata getMetadata() {
        return Metadata.builder()
                .region(EC2MetadataUtils.getEC2InstanceRegion())
                .availabilityZone(EC2MetadataUtils.getAvailabilityZone())
                .build();
    }

    @Data
    @Builder
    private static class Metadata {
        private String region;
        private String availabilityZone;
    }
}
