package org.urbancode.terraform.commands.vmware;

import org.urbancode.terraform.commands.common.Command;
import org.urbancode.terraform.commands.common.CommandException;
import org.urbancode.terraform.tasks.vmware.ContextVmware;

public class ResumeCommand implements Command {

    //**********************************************************************************************
    // CLASS
    //**********************************************************************************************

    //**********************************************************************************************
    // INSTANCE
    //**********************************************************************************************
    private ContextVmware context;

    //----------------------------------------------------------------------------------------------
    public ResumeCommand(ContextVmware context) {
        this.context = context;
    }


    //----------------------------------------------------------------------------------------------
    @Override
    public void execute()
    throws CommandException {
        // TODO this command will resume all instances in an environment

    }

}
