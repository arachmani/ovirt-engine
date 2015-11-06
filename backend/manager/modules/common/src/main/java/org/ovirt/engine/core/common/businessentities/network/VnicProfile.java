package org.ovirt.engine.core.common.businessentities.network;

import java.util.Map;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.ovirt.engine.core.common.businessentities.BusinessEntitiesDefinitions;
import org.ovirt.engine.core.common.businessentities.BusinessEntity;
import org.ovirt.engine.core.common.businessentities.IVdcQueryable;
import org.ovirt.engine.core.common.businessentities.Nameable;
import org.ovirt.engine.core.common.utils.ToStringBuilder;
import org.ovirt.engine.core.common.validation.annotation.ValidName;
import org.ovirt.engine.core.common.validation.group.CreateEntity;
import org.ovirt.engine.core.common.validation.group.RemoveEntity;
import org.ovirt.engine.core.common.validation.group.UpdateEntity;
import org.ovirt.engine.core.compat.Guid;

public class VnicProfile implements IVdcQueryable, BusinessEntity<Guid>, Nameable {
    private static final long serialVersionUID = 1019016330475623259L;

    @NotNull(groups = { UpdateEntity.class, RemoveEntity.class })
    private Guid id;
    @Size(min = 1, max = BusinessEntitiesDefinitions.VNIC_PROFILE_NAME_SIZE, groups = { CreateEntity.class,
            UpdateEntity.class })
    @ValidName(message = "VALIDATION_NAME_INVALID", groups = { CreateEntity.class, UpdateEntity.class })
    private String name;
    @NotNull(groups = { CreateEntity.class, UpdateEntity.class })
    private Guid networkId;
    private Guid networkQosId;

    private boolean portMirroring;
    private boolean passthrough;
    private String description;
    private Map<String, String> customProperties;

    @Override
    public Guid getId() {
        return id;
    }

    @Override
    public void setId(Guid id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPortMirroring() {
        return portMirroring;
    }

    public void setPortMirroring(boolean portMirroring) {
        this.portMirroring = portMirroring;
    }

    public boolean isPassthrough() {
        return passthrough;
    }

    public void setPassthrough(boolean passthrough) {
        this.passthrough = passthrough;
    }

    public Map<String, String> getCustomProperties() {
        return customProperties;
    }

    public void setCustomProperties(Map<String, String> customProperties) {
        this.customProperties = customProperties;
    }

    public Guid getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Guid networkId) {
        this.networkId = networkId;
    }

    public Guid getNetworkQosId() {
        return networkQosId;
    }

    public void setNetworkQosId(Guid networkQosId) {
        this.networkQosId = networkQosId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Object getQueryableId() {
        return getId();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustomProperties() == null) ? 0 : getCustomProperties().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNetworkId() == null) ? 0 : getNetworkId().hashCode());
        result = prime * result + ((getNetworkQosId() == null) ? 0 : getNetworkQosId().hashCode());
        result = prime * result + (isPortMirroring() ? 1231 : 1237);
        result = prime * result + (isPassthrough() ? 1231 : 1237);
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof VnicProfile)) {
            return false;
        }
        VnicProfile other = (VnicProfile) obj;
        if (!Objects.equals(getCustomProperties(), other.getCustomProperties())) {
            return false;
        }
        if (!Objects.equals(getId(), other.getId())) {
            return false;
        }
        if (!Objects.equals(getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(getNetworkId(), other.getNetworkId())) {
            return false;
        }
        if (!Objects.equals(getNetworkQosId(), other.getNetworkQosId())) {
            return false;
        }
        if (isPortMirroring() != other.isPortMirroring()) {
            return false;
        }
        if (isPassthrough() != other.isPassthrough()) {
            return false;
        }
        if (!Objects.equals(getDescription(), other.getDescription())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ToStringBuilder.forInstance(this)
                .append("id", getId())
                .append("networkId", getNetworkId())
                .append("networkQosId", getNetworkQosId())
                .append("portMirroring", isPortMirroring())
                .append("passthrough", isPassthrough())
                .append("customProperties", getCustomProperties())
                .append("description", getDescription())
                .build();
    }
}
