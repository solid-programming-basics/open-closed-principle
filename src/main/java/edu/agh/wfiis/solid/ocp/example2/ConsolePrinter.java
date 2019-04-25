package edu.agh.wfiis.solid.ocp.example2;

public class ConsolePrinter implements HandlingResult {

	public void handleResult(int result) {
		System.out.println(result);
	}
}
