test_qa_headless_15_fork:
	mvn clean verify -DforkCount=15 -DtagName=~@ignore

run_presentation_test:
	mvn clean verify -DtagName=@Presentation

run_a_check_on_chrome:
	mvn clean verify -DtagName=@Test -DBROWSER=chrome

test_qa_in_firefox:
	mvn clean verify -DforkCount=15 -DtagName=~@ignore -DBROWSER=firefox

test_prod_headless_15_fork:
	mvn clean verify -DENV=prod -DCRED=prodtest -DforkCount=15 -DtagName=~@ignore

test_prod_in_chrome_browser:
	mvn verify -DBROWSER=chrome -DENV=prod -DCRED=prodtest