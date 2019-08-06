package com.imooc.designPattern.command;

public class OpenChromeCommand implements Command {

	MacbookPro macbookPro;
    public OpenChromeCommand(MacbookPro macbookPro) {
        this.macbookPro = macbookPro;
    }
    
	@Override
	public void execute() {
		 macbookPro.openChrome();
	}

	@Override
	public void undo() {
		macbookPro.closeChrome();
	}

}
